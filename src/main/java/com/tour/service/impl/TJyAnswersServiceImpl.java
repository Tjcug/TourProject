package com.tour.service.impl;

import com.tour.model.TJyanswers;
import com.tour.service.TJyAnswersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by 79875 on 2016/12/19.
 */
@Transactional(propagation= Propagation.REQUIRED)
@Service("tJyAnswersService")
public class TJyAnswersServiceImpl extends BaseServiceImpl implements TJyAnswersService {

    @Override
    public boolean isAnswersByUseridAndQuestionsid(int userid, int questionsid) {
        List<TJyanswers> tJyanswerses = tJyanswersDAO.getSession().createQuery("from TJyanswers where user_id=:userid and question_id=:qutstionsid")
                .setInteger("userid", userid)
                .setInteger("qutstionsid", questionsid)
                .list();
        if(tJyanswerses!=null&& tJyanswerses.size()>0)
            return true;
        else
        return false;
    }

    @Override
    public TJyanswers findAnswerByUseridAndQuestionid(int userid, int questionsid) {
        List<TJyanswers> tJyanswerses = tJyanswersDAO.getSession().createQuery("from TJyanswers where user_id=:userid and question_id=:qutstionsid")
                .setInteger("userid", userid)
                .setInteger("qutstionsid", questionsid)
                .list();
        if(tJyanswerses!=null && tJyanswerses.size()>0)
        return tJyanswerses.get(0);
        else
            return null;
    }

    @Override
    public long addJyAnswerByQuestionsidAndUserId(int questionsid, int userid) {
        TJyanswers tJyanswers = new TJyanswers();
        //存储回答问题的记录
        tJyanswers.setTUser(tUserDAO.findById(Long.valueOf(userid)));
        tJyanswers.setFromuserscore(0);
        tJyanswers.setTouserscore(0);
        tJyanswers.setCreateTime(new Date());
        byte state=1;//正在解决问题
        tJyanswers.setState(state);
        tJyanswers.setTJyquestions(tJyquestionsDAO.findById(Long.valueOf(questionsid)));
        tJyanswersDAO.save(tJyanswers);
        return tJyanswers.getId();
    }

    @Override
    public void successSolveProblem(int answerid) {
        TJyanswers tJyanswers = tJyanswersDAO.findById(Long.valueOf(answerid));
        byte state = 2;//表示成功解决问题
        tJyanswers.setState(state);
        tJyanswersDAO.update(tJyanswers);
    }

    @Override
    public void nowSolveProblem(int answerid) {
        TJyanswers tJyanswers = tJyanswersDAO.findById(Long.valueOf(answerid));
        byte state = 1;//表示正在解决问题
        tJyanswers.setState(state);
        tJyanswersDAO.update(tJyanswers);
    }

    @Override
    public void failSolveProblem(int answerid) {
        TJyanswers tJyanswers = tJyanswersDAO.findById(Long.valueOf(answerid));
        byte state = 0;//表示失败解决问题
        tJyanswers.setState(state);
        tJyanswersDAO.update(tJyanswers);
    }

    @Override
    public void save(TJyanswers tJyanswers) {
        tJyanswersDAO.save(tJyanswers);
    }

    @Override
    public void update(TJyanswers tJyanswers) {
        tJyanswersDAO.update(tJyanswers);
    }

    @Override
    public void merge(TJyanswers tJyanswers) {
        tJyanswersDAO.merge(tJyanswers);
    }

    @Override
    public void delete(int id) {
        tJyanswersDAO.delete(get(id));
    }

    @Override
    public TJyanswers get(int id) {
        return tJyanswersDAO.findById(Long.valueOf(id));
    }

    @Override
    public List<TJyanswers> queryALL() {
        return tJyanswersDAO.findAll();
    }
}
