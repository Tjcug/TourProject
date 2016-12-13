package com.tour.service;

import com.tour.model.TJyquestions;

import java.util.List;

public interface TJyQuestionsService extends BaseService<TJyquestions>{
    //获取从lastID后一个ID开始后面count个及应提问（按创建时间排序）
    public List<TJyquestions> getCountJy(int lastID,int count);

    //获取指定用户的已解决的提问及应或者回答及应
    public List<TJyquestions> getUserJy(int userID,int type,int index,int count);
}
