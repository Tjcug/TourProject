package com.tour.service.impl;

import com.tour.model.TDiscusslikes;
import com.tour.service.TDiscusslikesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation=Propagation.REQUIRED)
@Service("tDiscusslikesService")
@SuppressWarnings("unchecked")
public class TDiscusslikesServiceImpl extends BaseServiceImpl implements TDiscusslikesService{

	@Override
	public void save(TDiscusslikes t) {
		// TODO 自动生成的方法存根
		tDiscusslikesDAO.save(t);
	}

	@Override
	public void update(TDiscusslikes t) {
		// TODO 自动生成的方法存根
		tDiscusslikesDAO.getSession().update(t);
	}

	@Override
	public void merge(TDiscusslikes t) {
		// TODO 自动生成的方法存根
		tDiscusslikesDAO.merge(t);
	}

	@Override
	public void delete(int id) {
		// TODO 自动生成的方法存根
		tDiscusslikesDAO.delete(get(id));
	}

	@Override
	public TDiscusslikes get(int id) {
		// TODO 自动生成的方法存根
		return tDiscusslikesDAO.findById(Long.valueOf(id));
	}

	@Override
	public List<TDiscusslikes> queryALL() {
		// TODO 自动生成的方法存根
		return tDiscusslikesDAO.findAll();
	}

}
