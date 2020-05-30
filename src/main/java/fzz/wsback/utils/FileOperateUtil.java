package fzz.wsback.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-28 16:01
 * @description 文件操作工具类
 */
public class FileOperateUtil {
    public static void writeToUserBookRatingFile(Integer userId, Integer bookId, Float wRating, Integer bookTypeId) {
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;
        File file = new File("..\\data\\wsback\\" + String.valueOf(bookTypeId) + ".csv");

        if (file.exists()){
             try{
                 fileOutputStream = new FileOutputStream(file);
                 outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
                 bufferedWriter = new BufferedWriter(outputStreamWriter);

                 bufferedWriter.write(userId + ", " + bookId + ", " + wRating);
                 bufferedWriter.newLine();
             } catch (IOException e){
                 e.printStackTrace();
             } finally {
                 if(bufferedWriter != null){
                     try {
                         bufferedWriter.close();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 }
                 if(outputStreamWriter != null){
                     try {
                         outputStreamWriter.close();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 }
                 if(fileOutputStream != null){
                     try {
                         fileOutputStream.close();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 }
             }
        }
    }
}
