package com.tour.service.impl;

import com.tour.dao.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("baseService")
public class BaseServiceImpl {

	@Resource
	protected AdministratorDAO administratorDAO;
	
	@Resource
	protected TDiscussDAO tDiscussDAO;
	
	@Resource
	protected TDiscusslikesDAO tDiscusslikesDAO;
	
	@Resource
	protected TOrderDAO tOrderDAO;
	
	@Resource
	protected TReplayDAO tReplayDAO;
	
	@Resource
	protected TUserDAO tUserDAO;
	
}
