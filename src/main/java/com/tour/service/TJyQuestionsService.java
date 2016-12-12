package com.tour.service;

import com.tour.model.TJyquestions;

import java.util.List;

public interface TJyQuestionsService extends BaseService<TJyquestions>{
    //获取从lastID后一个ID开始后面count个及应提问（按创建时间排序）
    public List<TJyquestions> queryCount(int lastID,int count);

}
