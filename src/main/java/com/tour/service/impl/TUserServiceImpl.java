package com.tour.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tour.model.TUser;
import com.tour.service.TUserService;
import com.tour.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional(propagation=Propagation.REQUIRED)
@Service("tUserService")
@SuppressWarnings("unchecked")
public class TUserServiceImpl extends BaseServiceImpl implements TUserService{

	@Autowired
	protected JsonUtil jsonUtil;

	@Override
	public void save(TUser t) {
		// TODO 自动生成的方法存根
		tUserDAO.save(t);
	}

	@Override
	public void update(TUser t) {
		// TODO 自动生成的方法存根
		tUserDAO.getSession().update(t);
	}

	@Override
	public void merge(TUser t) {
		// TODO 自动生成的方法存根
		tUserDAO.merge(t);
	}

	@Override
	public void delete(int id) {
		// TODO 自动生成的方法存根
		tUserDAO.delete(get(id));
	}

	@Override
	public TUser get(int id) {
		// TODO 自动生成的方法存根
		return tUserDAO.findById(Long.valueOf(id));
	}

	@Override
	public List<TUser> queryALL() {
		// TODO 自动生成的方法存根
		return tUserDAO.findAll();
	}

	@Override
	public String queryTuserByPage(String name, int page, int size) {
		List<TUser> userList=tUserDAO.queryTUserByPage(name,page, size);
		Long total=tUserDAO.getCount(name);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		Map map=new HashMap();
		map.put("total",total);
		map.put("rows",jsonUtil.fromTUserList(userList));
		//map.put("rows",userList);
		return gson.toJson(map);
	}

	/**
	 *  是否被注册过了
	 * @param username
	 * @return
     */
	@Override
	public boolean isLoginByUserName(String username) {
		final List userList = tUserDAO.findByProperty("userName", username);
        if(userList.size()!=0)
			return true;
		else
		return false;
	}

    @Override
    public boolean isLoginByUserTelehoneNumber(String telephpneNumber) {
        final List userList = tUserDAO.findByProperty("telephone", telephpneNumber);
        if(userList.size()!=0)
            return true;
        else
            return false;
    }
}
