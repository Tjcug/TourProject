package com.tour.service.impl;

import com.tour.model.TJyanswerscontentimage;
import com.tour.service.TJyAnswersImageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 79875 on 2016/12/19.
 */
@Transactional(propagation= Propagation.REQUIRED)
@Service("tJyAnswersImageService")
public class TJyAnswersImageServiceImpl extends BaseServiceImpl implements TJyAnswersImageService {

    @Override
    public void save(TJyanswerscontentimage tJyanswerscontentimage) {
        tJyanswerscontentimageDAO.save(tJyanswerscontentimage);
    }

    @Override
    public void update(TJyanswerscontentimage tJyanswerscontentimage) {
        tJyanswerscontentimageDAO.update(tJyanswerscontentimage);
    }

    @Override
    public void merge(TJyanswerscontentimage tJyanswerscontentimage) {
        tJyanswerscontentimageDAO.merge(tJyanswerscontentimage);
    }

    @Override
    public void delete(int id) {
        tJyanswerscontentimageDAO.delete(get(id));
    }

    @Override
    public TJyanswerscontentimage get(int id) {
        return tJyanswerscontentimageDAO.findById(Long.valueOf(id));
    }

    @Override
    public List<TJyanswerscontentimage> queryALL() {
        return tJyanswerscontentimageDAO.findAll();
    }
}
