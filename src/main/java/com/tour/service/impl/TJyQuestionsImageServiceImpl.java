package com.tour.service.impl;

import com.tour.model.TJyquestions;
import com.tour.model.TJyquestionsimage;
import com.tour.service.TJyQuestionsImageService;
import com.tour.service.TJyQuestionsService;
import com.tour.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation=Propagation.REQUIRED)
@Service("tJyQuestionsImageService")
@SuppressWarnings("unchecked")
public class TJyQuestionsImageServiceImpl extends BaseServiceImpl implements TJyQuestionsImageService {

	@Autowired
	protected JsonUtil jsonUtil;

	@Override
	public void save(TJyquestionsimage t) {
		// TODO 自动生成的方法存根
		tJyquestionsimageDAO.save(t);
	}

	@Override
	public void update(TJyquestionsimage t) {
		// TODO 自动生成的方法存根
		tJyquestionsimageDAO.getSession().update(t);
	}

	@Override
	public void merge(TJyquestionsimage t) {
		// TODO 自动生成的方法存根
		tJyquestionsimageDAO.merge(t);
	}

	@Override
	public void delete(int id) {
		// TODO 自动生成的方法存根
		tJyquestionsimageDAO.delete(get(id));
	}

	@Override
	public TJyquestionsimage get(int id) {
		// TODO 自动生成的方法存根
		return tJyquestionsimageDAO.findById(Long.valueOf(id));
	}

	@Override
	public List<TJyquestionsimage> queryALL() {
		// TODO 自动生成的方法存根
		return tJyquestionsimageDAO.findAll();
	}

	/**
	 * 根据提问及应的id获取照片(第一张)
	 * @param id 提问及应的id
	 * @return 返回json对象
	 */
	@Override
	public TJyquestionsimage getByQuestionID(int id){
		return (TJyquestionsimage) tJyquestionsimageDAO.findByProperty("question_id",id).get(0);
	}

	/**
	 * 根据提问及应的id获取照片(所有照片)
	 * @param id 提问及应的id
	 * @return 返回json对象
	 */
	@Override
	public List<TJyquestionsimage> getAllByQuestionID(int id){
		return tJyquestionsimageDAO.findByProperty("question_id",id);
	}

}
