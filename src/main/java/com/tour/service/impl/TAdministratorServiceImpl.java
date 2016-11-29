package com.tour.service.impl;

import com.tour.model.Administrator;
import com.tour.service.TAdministratorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dell-pc on 2016/4/22.
 */

@Transactional(propagation= Propagation.REQUIRED)
@Service("tAdministratorService")
public class TAdministratorServiceImpl extends BaseServiceImpl implements TAdministratorService {

    @Override
    public void save(Administrator administrator) {
        administratorDAO.save(administrator);
    }

    @Override
    public void update(Administrator administrator) {
        administratorDAO.getSession().update(administrator);
    }

    @Override
    public void merge(Administrator administrator) {
        administratorDAO.merge(administrator);
    }

    @Override
    public void delete(int id) {
        administratorDAO.delete(get(id));
    }

    @Override
    public Administrator get(int id) {
        return administratorDAO.findById(Long.valueOf(id));
    }

    @Override
    public List<Administrator> queryALL() {
        return administratorDAO.findAll();
    }

    @Override
    public Administrator findadminByusernameAndPass(String username, String password) {
        return administratorDAO.findadminByusernameAndPass(username, password);
    }
}
