package com.tour.service.impl;

import com.tour.model.TJyquestions;
import com.tour.service.TJyQuestionsService;
import com.tour.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
	 * 获取从lastID后一个ID开始后面count个及应提问（按创建时间排序）
	 */
	@Override
	public int getCount() {
		//String hql = "select count(j) from TJyquestions j";
		return tJyquestionsDAO.findAll().size();
	}



	/**
	 * 获取从lastID后一个ID开始后面count个及应提问（按创建时间排序）
	 * @param lastID 上一次获取的最后一个及应提问id（本次从lastID后一个开始）
	 * @param count 获取的数量
	 * @return 返回json对象
	 */
	@Override
	public List<TJyquestions> getCountJy(int lastID,int count) {
		String hql = "select j from TJyquestions j inner join fetch j.TUser u where j.state=0 order by j.createTime desc";
		//查出所有未解决的及应按时间倒序排序
		List<TJyquestions> jyQuestionList = tJyquestionsDAO.findList(hql);
		List<TJyquestions> jyQuestionList2 = new ArrayList<>();
		//获取最新时
		if(lastID == 0) {
			for (int i = 0; i < count; i++)
				jyQuestionList2.add(jyQuestionList.get(i));
		}
		else {
			//取出id为lastID的及应的后面count个及应
			for (int i = 0; i < jyQuestionList.size(); i++) {
				if (jyQuestionList.get(i).getId() == lastID) {
					for (int j = 0; j < count; j++) {
						if (i + 1 + j == jyQuestionList.size())
							break;
						jyQuestionList2.add(jyQuestionList.get(i + 1 + j));
					}
					break;
				}
			}
		}
		return jyQuestionList2;
	}

	/**
	 * 获取指定用户的已解决的提问及应或者回答及应
	 * @param userID 用户id
	 * @param type 1为回答的及应，0为提问的及应
	 * @return 返回json对象
	 */
	@Override
	public List<TJyquestions> getUserJy(int userID,int type,int index,int count){
		//查出所有未解决的及应按时间倒序排序
		final List<TJyquestions> jyQuestionList = tJyquestionsDAO.findList("select * from t_jyquestions where state="+type+" and user_id="+userID+" order by create_time desc");
		final List<TJyquestions> jyQuestionList2 = null;
		//判断是否取了过多的数据
		int size = jyQuestionList.size();
		count = index+count<size?count:size-index;
		//取出id为lastID的及应的后面count个及应
		for (int i = 0; i < count; i++){
			jyQuestionList2.add(jyQuestionList.get(index+1+i));
		}
		return jyQuestionList2;

	}

	@Override
	public void successSolveProblem(int questionID) {
		TJyquestions tJyquestions = tJyquestionsDAO.findById(Long.valueOf(questionID));
		tJyquestions.setState(true);
		tJyquestionsDAO.update(tJyquestions);
	}


}
