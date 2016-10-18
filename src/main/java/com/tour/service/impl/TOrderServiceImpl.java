package com.tour.service.impl;

import com.tour.model.TOrder;
import com.tour.service.TOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation=Propagation.REQUIRED)
@Service("tOrderService")
@SuppressWarnings("unchecked")
public class TOrderServiceImpl extends BaseServiceImpl implements TOrderService{

	@Override
	public void save(TOrder t) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void update(TOrder t) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void merge(TOrder t) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void delete(int id) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public TOrder get(int id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<TOrder> queryALL() {
		// TODO 自动生成的方法存根
		return null;
	}

}
