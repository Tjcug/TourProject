package com.tour.service;

import com.tour.model.TUser;

public interface TUserService extends BaseService<TUser>{

    //分页查询用户信息
    public String queryTuserByPage(String name, int page, int size);

    //判断用户名是否存在
    public boolean isLoginByUserName(String username);

    //判断电话号码是否存在
    public boolean isLoginByUserTelehoneNumber(String telephpneNumber);
}
