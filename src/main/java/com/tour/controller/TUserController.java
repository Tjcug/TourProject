package com.tour.controller;

import com.tour.model.TUser;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell-pc on 2016/4/23.
 */

@Controller
@Transactional(propagation= Propagation.REQUIRED)
@RequestMapping("/tuser")
public class TUserController extends BaseController{

    @RequestMapping(value = "/queryUserByPage",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String queryUserByPage(TUser user, @RequestParam Integer page,
                                  @RequestParam Integer rows){
        return userService.queryTuserByPage(user.getUserName(),page,rows);
    }

    /**
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/save",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String saveUser(TUser user){
        Map map=new HashMap<>();
        try {
            userService.save(user);
            log.info(user.getUserName());
            map.put("success",true);
        }catch (Exception e){
            map.put("errorMsg",e.getMessage());
            e.printStackTrace();;
        }
        return gson.toJson(map);
    }

    /**
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/delete",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String deleteUser(TUser user){
        Map map=new HashMap<>();
        try {
            userService.delete((int)user.getId());
            map.put("success",true);
        }catch (Exception e){
            map.put("errorMsg",e.getMessage());
            e.printStackTrace();;
        }
        return gson.toJson(map);
    }

    /**
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/update",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String updateUser(TUser user){
        Map map=new HashMap<>();
        try {
            userService.update(user);
            map.put("success",true);
        }catch (Exception e){
            map.put("errorMsg",e.getMessage());
            e.printStackTrace();;
        }
        return gson.toJson(map);
    }

}
