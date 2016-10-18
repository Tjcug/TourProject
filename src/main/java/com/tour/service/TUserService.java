package com.tour.service;

import com.tour.model.TUser;

public interface TUserService extends BaseService<TUser>{

    public String queryTuserByPage(String name, int page, int size);

}
