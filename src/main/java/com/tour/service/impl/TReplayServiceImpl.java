package com.tour.service.impl;

import com.tour.model.TReplay;
import com.tour.service.TReplayService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation=Propagation.REQUIRED)
@Service("tReplayService")
@SuppressWarnings("unchecked")
public class TReplayServiceImpl extends BaseServiceImpl implements TReplayService{

	@Override
	public void save(TReplay t) {
		// TODO 自动生成的方法存根
		tReplayDAO.save(t);
	}

	@Override
	public void update(TReplay t) {
		// TODO 自动生成的方法存根
		tReplayDAO.getSession().update(t);
	}

	@Override
	public void merge(TReplay t) {
		// TODO 自动生成的方法存根
		tReplayDAO.merge(t);
	}

	@Override
	public void delete(int id) {
		// TODO 自动生成的方法存根
		tReplayDAO.delete(get(id));
	}

	@Override
	public TReplay get(int id) {
		// TODO 自动生成的方法存根
		return tReplayDAO.findById(Long.valueOf(id));
	}

	@Override
	public List<TReplay> queryALL() {
		// TODO 自动生成的方法存根
		return tReplayDAO.findAll();
	}

}
