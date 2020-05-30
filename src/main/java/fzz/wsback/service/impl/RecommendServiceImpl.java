package fzz.wsback.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import fzz.wsback.dao.*;
import fzz.wsback.domain.BookInfo;
import fzz.wsback.domain.BookTypeInfo;
import fzz.wsback.service.RecommendService;
import fzz.wsback.utils.RedisUtil;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-27 20:05
 * @description 系统推荐 SERVICE 层实现
 */
@Service(value = "RecommendService")
@EnableScheduling
public class RecommendServiceImpl implements RecommendService {
    private UserTypeNumberDao userTypeNumberDao;
    private BookOperateNumberDao bookOperateNumberDao;
    private UserDao userDao;
    private BookDao bookDao;
    private BookTypeDao bookTypeDao;
    private BusinessDao businessDao;
    private RedisUtil redisUtil;

    @Autowired
    public RecommendServiceImpl(UserTypeNumberDao userTypeNumberDao, BookOperateNumberDao bookOperateNumberDao, UserDao userDao, BookDao bookDao, BookTypeDao bookTypeDao, BusinessDao businessDao, RedisUtil redisUtil) {
        this.userTypeNumberDao = userTypeNumberDao;
        this.bookOperateNumberDao = bookOperateNumberDao;
        this.userDao = userDao;
        this.bookDao = bookDao;
        this.bookTypeDao = bookTypeDao;
        this.businessDao = businessDao;
        this.redisUtil = redisUtil;
    }

    @Override
    public JSONArray getRecommendMahout(Integer userId) {
        List<Object> dataList = redisUtil.lGet(String.valueOf(userId), 0, -1);
        return JSONArray.parseArray(JSON.toJSONString(dataList.get(0)));
    }

    @Override
    public JSONArray getRecommendSystem() {
        List<Object> dataList = redisUtil.lGet("systemRecommend", 0, -1);
        return JSONArray.parseArray(JSON.toJSONString(dataList.get(0)));
    }

    @Override
    public JSONArray getRecommendSystemHot() {
        List<Object> dataList = redisUtil.lGet("hotRecommend", 0, -1);
        return JSONArray.parseArray(JSON.toJSONString(dataList.get(0)));
    }

    @Override
    public JSONArray getRecommendBusinessHot(Integer businessId) {
        List<Object> dataList = redisUtil.lGet(businessId + "HotRecommend", 0, -1);
        return JSONArray.parseArray(JSON.toJSONString(dataList.get(0)));
    }

    /**
     * 通过 mahout 实现基于物品协同的推荐，针对的是单独的用户个体，并存入缓存中（redis-0）
     */
    @Scheduled(cron = "0 0 0/12 * * ?")
    public void doRecommendMahout() {
        try {
            // 准备数据，获取文件夹下文件列表
            File[] fileList = new File("..\\data\\wsback").listFiles();

            if (fileList != null) {
                for (File file : fileList) {
                    //将数据加载到内存中
                    DataModel dataModel = new FileDataModel(file);

                    // 物品相似度
                    ItemSimilarity similarity = new EuclideanDistanceSimilarity(dataModel);
                    // 构建基于物品的推荐系统
                    Recommender recommender = new GenericItemBasedRecommender(dataModel, similarity);
                    // 得到指定用户的推荐结果
                    LongPrimitiveIterator iterator = dataModel.getUserIDs();

                    while (iterator.hasNext()) {
                        long userId = iterator.nextLong();
                        List<RecommendedItem> list = recommender.recommend(userId, 12);
                        redisUtil.del(userId + "-" + file.getName().replace(".csv", ""));
                        redisUtil.lSet(userId + "-" +file.getName().replace(".csv", ""), list);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取 redis 中针对用户的物品协同推荐的列表，获取数据库中详细信息，并存入 redis 中
     */
    @Scheduled(cron = "0 0 0/4 * * ?")
    public void doRecommendToSaveUserTypes() {
        try {
            List<Integer> userIdList = userDao.getAllUserId();

            for (Integer userId : userIdList) {
                List<JSONObject> currUserRecommendJsonObjectList = new ArrayList<>();
                List<Integer> bookTypeIdList = userTypeNumberDao.getUserTypeNumberTop5ByUserId(userId);

                for (Integer bookTypeId : bookTypeIdList) {
                    JSONObject jsonCurrTypeRecommendObject = new JSONObject();
                    JSONArray jsonCurrTypeRecommendArray = new JSONArray();
                    BookTypeInfo bookTypeInfo = bookTypeDao.getBookTypeInfoByBookTypeId(bookTypeId);
                    List<Object> dataList = redisUtil.lGet(userId + "-" + bookTypeInfo.getBookTypeId(), 0, -1);
                    JSONArray dataArray = JSONArray.parseArray(JSON.toJSONString(dataList.get(0)));

                    if (!dataArray.isEmpty()) {
                        for (Object object : dataArray) {
                            JSONObject jsonObject = (JSONObject) object;
                            BookInfo bookInfo = bookDao.getBookInfoById(jsonObject.getInteger("itemID"));
                            jsonCurrTypeRecommendArray.add(JSONObject.toJSON(bookInfo));
                        }
                    }

                    jsonCurrTypeRecommendObject.put("bookTypeName", bookTypeInfo.getBookTypeName());
                    jsonCurrTypeRecommendObject.put("bookRecommend", jsonCurrTypeRecommendArray);

                    currUserRecommendJsonObjectList.add(jsonCurrTypeRecommendObject);

                    redisUtil.del(String.valueOf(userId));
                    redisUtil.lSet(String.valueOf(userId), currUserRecommendJsonObjectList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取推荐，当缓存中没有基于该用户的推荐内容时使用、以及商城热销推荐
     */
    @Scheduled(cron = "0 0 0/6 * * ?")
    public void doRecommendSystem() {
        List<Integer> clickTop18BookIdList = bookOperateNumberDao.getBookOperateNumberClickTop18();
        List<Integer> addTop6BookIdList = bookOperateNumberDao.getBookOperateNumberAddTop6();

        // 做首页用户无协同推荐时选项
        List<JSONObject> clickTop18BookInfoList = new ArrayList<>();
        // 做商城热销推荐（BookList 页面左侧边栏）
        List<JSONObject> addTop6BookInfoList = new ArrayList<>();

        for (Integer bookId: clickTop18BookIdList){
            clickTop18BookInfoList.add((JSONObject) JSONObject.toJSON(bookDao.getBookInfoById(bookId)));
        }
        for (Integer bookId: addTop6BookIdList){
            addTop6BookInfoList.add((JSONObject) JSONObject.toJSON(bookDao.getBookInfoById(bookId)));
        }

        redisUtil.del("systemRecommend");
        redisUtil.lSet("systemRecommend", clickTop18BookInfoList);
        redisUtil.del("hotRecommend");
        redisUtil.lSet("hotRecommend", addTop6BookInfoList);
    }

    /**
     * 获取推荐, 店铺热销推荐
     */
    @Scheduled(cron = "0 0 0/22 * * ?")
    public void doRecommendBusiness() {
        List<Integer> businessIdList = businessDao.getAllBusinessId();

        for (Integer businessId : businessIdList) {
            List<Integer> businessAddTop5BookIdList = bookOperateNumberDao.getBookOperateNumberBusinessAddTop5(businessId);

            // 做店铺热销推荐（BookDetail 页面左侧边栏）
            List<JSONObject> businessAddTop5BookInfoList = new ArrayList<>();

            for (Integer bookId : businessAddTop5BookIdList) {
                businessAddTop5BookInfoList.add((JSONObject) JSONObject.toJSON(bookDao.getBookInfoById(bookId)));
            }

            redisUtil.del(businessId + "HotRecommend");
            redisUtil.lSet(businessId + "HotRecommend", businessAddTop5BookInfoList);
        }
    }
}
