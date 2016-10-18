package com.tour.service;

import com.tour.model.Administrator;

/**
 * Created by dell-pc on 2016/4/22.
 */
public interface TAdministratorService extends BaseService<Administrator>{
    public Administrator findadminByusernameAndPass(String username,String password);
}
