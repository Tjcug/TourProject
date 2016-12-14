package com.tour.service;

import com.tour.model.TJyquestionsimage;
import java.util.List;


public interface TJyQuestionsImageService extends BaseService<TJyquestionsimage>{

    //根据提问及应的id获取照片
    public List<TJyquestionsimage>  getByQuestionID(long id,int type);

}
