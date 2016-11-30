package com.tour.dao;

import com.tour.Application;
import com.tour.model.TUser;
import com.tour.page.Pagination;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell-pc on 2016/4/22.
 */

//用SpringBoot的方式生成测试用例
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest("server.port:0")
@TransactionConfiguration(defaultRollback=false)
@Transactional(propagation= Propagation.REQUIRED)
public class TUserDaoTest {

    @Autowired
    private TUserDAO userDAO;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

//    @Test
//    public void test()throws Exception{
//        TUser user=new TUser();
//        user.setUserName("谭杰");
//        userDAO.save(user);
//        System.out.println(userDAO.get(TUser.class,Long.valueOf(8)));
//    }

    @Test
    public void getByQueryString()throws Exception{
        TUser user=new TUser();
        user.setUserName("谭杰");
        user.setTelephone("13072783289");
        userDAO.save(user);
        System.out.println(userDAO.get("from TUser where userName=?","tanjie"));
    }

    @Test
    public void getByQueryStringMap()throws Exception{
        TUser user=new TUser();
        user.setUserName("谭杰");
        user.setTelephone("13072783289");
        userDAO.save(user);
        Map map=new HashMap();
        map.put("name","tanjie");
        System.out.println(userDAO.get("from TUser where userName=:name",map));
    }


    @Test
    public void findPagination()throws Exception{
        Map map=new HashMap();
        map.put("name","谭杰");
        System.out.println(userDAO.get("from TUser where userName=:name",map));
        Pagination<TUser> page=userDAO.findPagination("from TUser where userName=:name",map,1,3);
        for(TUser temp:page.getItems()){
            System.out.println(temp.getUserName());
        }
    }

    @Test
    public void Test(){
        System.out.println(userDAO.findAll());
    }
}
