package com.tour.service.impl;

import com.tour.model.TAssistantanswers;
import com.tour.service.TAssistantanswersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation=Propagation.REQUIRED)
@Service("tAssistantanswersService")
@SuppressWarnings("unchecked")
public class TAssistantanswersServiceImpl extends BaseServiceImpl implements TAssistantanswersService{

	@Override
	public void save(TAssistantanswers t) {
		// TODO 自动生成的方法存根
		tAssistantanswersDAO.save(t);
	}

	@Override
	public void update(TAssistantanswers t) {
		// TODO 自动生成的方法存根
		tAssistantanswersDAO.getSession().update(t);
	}

	@Override
	public void merge(TAssistantanswers t) {
		// TODO 自动生成的方法存根
		tAssistantanswersDAO.merge(t);
	}

	@Override
	public void delete(int id) {
		// TODO 自动生成的方法存根
		tAssistantanswersDAO.delete(get(id));
	}

	@Override
	public TAssistantanswers get(int id) {
		// TODO 自动生成的方法存根
		return tAssistantanswersDAO.findById(Long.valueOf(id));
	}

	@Override
	public List<TAssistantanswers> queryALL() {
		// TODO 自动生成的方法存根
		return tAssistantanswersDAO.findAll();
	}
	
}
