package com.tour.service.impl;

import com.tour.model.TJyanswerscontent;
import com.tour.service.TJyAnswersContentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 79875 on 2016/12/19.
 */
@Transactional(propagation= Propagation.REQUIRED)
@Service("tJyAnswersContentService")
public class TJyAnswersContentServiceImpl  extends BaseServiceImpl implements TJyAnswersContentService {

    @Override
    public void save(TJyanswerscontent tJyanswerscontent) {
        tJyanswerscontentDAO.save(tJyanswerscontent);
    }

    @Override
    public void update(TJyanswerscontent tJyanswerscontent) {
        tJyanswerscontentDAO.update(tJyanswerscontent);
    }

    @Override
    public void merge(TJyanswerscontent tJyanswerscontent) {
        tJyanswerscontentDAO.merge(tJyanswerscontent);
    }

    @Override
    public void delete(int id) {
        tJyanswerscontentDAO.delete(get(id));
    }

    @Override
    public TJyanswerscontent get(int id) {
        return tJyanswerscontentDAO.findById(Long.valueOf(id));
    }

    @Override
    public List<TJyanswerscontent> queryALL() {
        return tJyanswerscontentDAO.findAll();
    }
}
