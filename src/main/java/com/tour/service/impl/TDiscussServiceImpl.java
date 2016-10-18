package com.tour.service.impl;

import com.tour.model.TDiscuss;
import com.tour.service.TDiscussService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation=Propagation.REQUIRED)
@Service("tDiscussService")
@SuppressWarnings("unchecked")
public class TDiscussServiceImpl extends BaseServiceImpl implements TDiscussService{

	@Override
	public void save(TDiscuss t) {
		// TODO 自动生成的方法存根
		tDiscussDAO.save(t);
	}

	@Override
	public void update(TDiscuss t) {
		// TODO 自动生成的方法存根
		tDiscussDAO.getSession().update(t);
	}

	@Override
	public void merge(TDiscuss t) {
		// TODO 自动生成的方法存根
		tDiscussDAO.merge(t);
	}

	@Override
	public void delete(int id) {
		// TODO 自动生成的方法存根
		tDiscussDAO.delete(get(id));
	}

	@Override
	public TDiscuss get(int id) {
		// TODO 自动生成的方法存根
		return tDiscussDAO.findById(Long.valueOf(id));
	}

	@Override
	public List<TDiscuss> queryALL() {
		// TODO 自动生成的方法存根
		return tDiscussDAO.findAll();
	}

}
