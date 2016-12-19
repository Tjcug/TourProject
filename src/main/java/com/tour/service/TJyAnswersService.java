package com.tour.service;

import com.tour.model.TJyanswers;

/**
 * Created by 79875 on 2016/12/19.
 */
public interface TJyAnswersService extends BaseService<TJyanswers> {

    //在问题数据库中是否含有相同的userid和questionsid，避免产生相同记录
    public boolean isAnswersByUseridAndQuestionsid(int userid, int questionsid);

    //通过用户id和问题id查找Answer
    public TJyanswers findAnswerByUseridAndQuestionid(int userid, int questionsid);

    //该答案成功解决了问题
    public void successSolveProblem(int answerid);
}
