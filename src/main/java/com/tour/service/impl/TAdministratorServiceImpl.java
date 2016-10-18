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
         tAdministratorDAO.save(administrator);
    }

    @Override
    public void update(Administrator administrator) {
        tAdministratorDAO.getSession().update(administrator);
    }

    @Override
    public void merge(Administrator administrator) {
        tAdministratorDAO.merge(administrator);
    }

    @Override
    public void delete(int id) {
        tAdministratorDAO.delete(get(id));
    }

    @Override
    public Administrator get(int id) {
        return tAdministratorDAO.findById(Long.valueOf(id));
    }

    @Override
    public List<Administrator> queryALL() {
        return tAdministratorDAO.findAll();
    }

    @Override
    public Administrator findadminByusernameAndPass(String username, String password) {
        return tAdministratorDAO.findadminByusernameAndPass(username, password);
    }
}
