package com.tour.service.impl;

import com.tour.model.TAssistantquestions;
import com.tour.service.TAssistantquestionsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation=Propagation.REQUIRED)
@Service("tAssistantquestionsService")
@SuppressWarnings("unchecked")
public class TAssistantquestionsServiceImpl extends BaseServiceImpl implements TAssistantquestionsService{

	@Override
	public void save(TAssistantquestions t) {
		// TODO 自动生成的方法存根
		tAssistantquestionsDAO.save(t);
	}

	@Override
	public void update(TAssistantquestions t) {
		// TODO 自动生成的方法存根
		tAssistantquestionsDAO.getSession().update(t);
	}

	@Override
	public void merge(TAssistantquestions t) {
		// TODO 自动生成的方法存根
		tAssistantquestionsDAO.merge(t);
	}

	@Override
	public void delete(int id) {
		// TODO 自动生成的方法存根
		tAssistantquestionsDAO.delete(get(id));
	}

	@Override
	public TAssistantquestions get(int id) {
		// TODO 自动生成的方法存根
		return tAssistantquestionsDAO.findById(Long.valueOf(id));
	}

	@Override
	public List<TAssistantquestions> queryALL() {
		// TODO 自动生成的方法存根
		return tAssistantquestionsDAO.findAll();
	}

}
