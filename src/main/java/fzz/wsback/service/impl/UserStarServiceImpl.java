package fzz.wsback.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import fzz.wsback.dao.BookDao;
import fzz.wsback.dao.BusinessDao;
import fzz.wsback.dao.UserStarDao;
import fzz.wsback.domain.BookInfo;
import fzz.wsback.domain.UserStar;
import fzz.wsback.service.UserStarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 用户收藏操作 SERVICE 层实现
 */
@Service(value = "userStarService")
public class UserStarServiceImpl implements UserStarService {
    private UserStarDao userStarDao;
    private BookDao bookDao;
    private BusinessDao businessDao;

    @Autowired
    public UserStarServiceImpl(UserStarDao userStarDao, BookDao bookDao, BusinessDao businessDao){
        this.userStarDao = userStarDao;
        this.bookDao = bookDao;
        this.businessDao = businessDao;
    }

    @Override
    public JSONArray getBookUserStarByUserId(Integer userId) {
        JSONArray jsonArray = new JSONArray();
        List<UserStar> userStarList = userStarDao.getBookUserStarByUserId(userId);

        for (UserStar userStar : userStarList){
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(bookDao.getBookInfoById(userStar.getUserStarId()));
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    @Override
    public JSONArray getBusinessUserStarByUserId(Integer userId) {
        JSONArray jsonArray = new JSONArray();
        List<UserStar> userStarList = userStarDao.getBusinessUserStarByUserId(userId);

        for (UserStar userStar : userStarList){
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(businessDao.getBusinessInfoByBusinessId(userStar.getUserStarId()));
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    @Override
    public UserStar getUserStarByUserIdAndUserStarId(Integer userId, Integer userStarId) {
        return userStarDao.getUserStarByUserIdAndUserStarId(userId, userStarId);
    }

    @Override
    public void insertUserStar(Integer userId, Integer userStarId, Integer userStarTag) {
        userStarDao.insertUserStar(userId, userStarId, userStarTag);
    }

    @Override
    public void updateUserStar(Integer userId, Integer userStarId) {
        userStarDao.updateUserStar(userId, userStarId);
    }
}
