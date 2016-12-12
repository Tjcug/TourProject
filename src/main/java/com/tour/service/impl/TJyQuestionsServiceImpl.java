package com.tour.service.impl;

import com.tour.model.TJyquestions;
import com.tour.service.TJyQuestionsService;
import com.tour.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation=Propagation.REQUIRED)
@Service("tJyQuestionsService")
@SuppressWarnings("unchecked")
public class TJyQuestionsServiceImpl extends BaseServiceImpl implements TJyQuestionsService {

	@Autowired
	protected JsonUtil jsonUtil;

	@Override
	public void save(TJyquestions t) {
		// TODO 自动生成的方法存根
		tJyquestionsDAO.save(t);
	}

	@Override
	public void update(TJyquestions t) {
		// TODO 自动生成的方法存根
		tJyquestionsDAO.getSession().update(t);
	}

	@Override
	public void merge(TJyquestions t) {
		// TODO 自动生成的方法存根
		tJyquestionsDAO.merge(t);
	}

	@Override
	public void delete(int id) {
		// TODO 自动生成的方法存根
		tJyquestionsDAO.delete(get(id));
	}

	@Override
	public TJyquestions get(int id) {
		// TODO 自动生成的方法存根
		return tJyquestionsDAO.findById(Long.valueOf(id));
	}

	@Override
	public List<TJyquestions> queryALL() {
		// TODO 自动生成的方法存根
		return tJyquestionsDAO.findAll();
	}

	/**
	 *  获取从lastID后一个ID开始后面count个及应提问（按创建时间排序）
	 * @param lastID 上一次获取的最后一个及应提问id（本次从lastID后一个开始）
	 * @param count 获取的数量
	 * @return 返回json对象
	 */
	@Override
	public List<TJyquestions> queryCount(int lastID,int count) {
		//查出所有未解决的及应按时间倒序排序
		final List<TJyquestions> jyQuestionList = tJyquestionsDAO.findList("select * from t_jyquestions where state=0 order by create_time desc");
		final List<TJyquestions> jyQuestionList2 = null;
		//取出id为lastID的及应的后面count个及应
		for (int i = 0; i < count; i++){
			if(jyQuestionList.get(i).getId() == lastID) {
				for (int j = 0;j<count;j++)
					jyQuestionList2.add(jyQuestionList.get(i+1+j));
				break;
			}
		}
		return jyQuestionList2;
	}




}
