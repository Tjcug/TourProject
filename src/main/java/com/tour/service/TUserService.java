package com.tour.service;

import com.tour.model.TUser;

public interface TUserService extends BaseService<TUser>{

    public String queryTuserByPage(String name, int page, int size);

    public boolean isLoginByUserName(String username);

    public boolean isLoginByUserTelehoneNumber(String telephpneNumber);

    public TUser loginTest(String username);
}
