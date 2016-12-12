package com.tour.service;

import com.tour.model.TJyquestionsimage;
import java.util.List;


public interface TJyQuestionsImageService extends BaseService<TJyquestionsimage>{
    //根据提问及应的id获取照片(第一张)
    public TJyquestionsimage getByQuestionID(int id);

    //根据提问及应的id获取照片(所有照片)
    public List<TJyquestionsimage> getAllByQuestionID(int id);
}
