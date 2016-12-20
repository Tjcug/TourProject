package com.tour.controller;

import com.google.gson.Gson;
import com.tour.model.TUser;
import org.omg.CORBA.Object;
import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell-pc on 2016/4/23.
 */

@Controller
@Transactional(propagation= Propagation.REQUIRED)
@RequestMapping("/tuser")
public class TUserController extends BaseController{

    public Map<String,String> registerCheck=new HashMap<>(); //关于用户注册的验证码
    public Map<String,String> loginCheck=new HashMap<>(); //关于用户登陆的验证码

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

    /**
     * 用户登陆或者注册时需要获得校验码
     * http://localhost:8080/tuser/getCheckNum/13072783289/register
     * http://localhost:8080/tuser/getCheckNum/13072783289/login
     * @param telephoneNumber 用户电话号码
     * @return 返回json对象
     */
    @RequestMapping(value = "/getCheckNum/{telephoneNumber}/{type}",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getCheckNum(@PathVariable("telephoneNumber") String telephoneNumber,
                              @PathVariable("type") String type) {
        Map map=new HashMap<>();
        log.info("telephoneNumber："+telephoneNumber);

        try {
            if(type.equals("register")){
                if(userService.isLoginByUserTelehoneNumber(telephoneNumber)){
                    //
                    map.put("errorMsg","该手机号已注册");
                    return gson.toJson(map);
                }
                //测试数据
                //registerCheck.put(telephoneNumber,"1234");
                //注册获取校验码
                registerCheck.put(telephoneNumber,messageUtil.generateCheckNum());
                log.info("checkNum："+registerCheck.get(telephoneNumber));
                messageUtil.sendMessage("及应","SMS_31795073","{'check':'"+registerCheck.get(telephoneNumber)+"'}",telephoneNumber);
            }else if(type.equals("login")){
                //登陆获取校验码
                loginCheck.put(telephoneNumber,messageUtil.generateCheckNum());
                log.info("checkNum："+loginCheck.get(telephoneNumber));
                messageUtil.sendMessage("及应","SMS_31795073","{'check':'"+loginCheck.get(telephoneNumber)+"'}",telephoneNumber);
            }else{
                return gson.toJson(map);
            }
            map.put("success",true);
        }catch (Exception e){
            map.put("errorMsg",e.getMessage());
            e.printStackTrace();
        }
        return gson.toJson(map);
    }

    /**
     * 用户注册通过校验码注册
     * http://localhost:8080/tuser/registerUser?telephoneNumber=13072783289&userName=test1&password=123456&checknum=6411
     * @param telephoneNumber 用户电话号码
     * @param userName  用户名
     * @param password 密码
     * @param checknum 校验码
     * @return
     */
    @RequestMapping(value = "/registerUser",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String registerUserByCheckNum(@RequestParam("telephoneNumber") String telephoneNumber,
                                         @RequestParam("userName") String userName,
                                         @RequestParam("password") String password,
                                         @RequestParam("checknum") String checknum) {
        log.info(telephoneNumber+" "+userName+" "+password+" "+checknum);
        Map map=new HashMap<>();
        if(checknum.equals(registerCheck.get(telephoneNumber))){
            //校验码验证成功

            //判断注册用户名是否被注册过了如果被注册后则注册失败
            if(userService.isLoginByUserName(userName)){
                map.put("errorMsg","该用户名已经被注册过了 请重新注册");
                return gson.toJson(map);
            }
            //判断注册手机号码是否被注册过了如果被注册后则注册失败
            if(userService.isLoginByUserTelehoneNumber(telephoneNumber)){
                map.put("errorMsg","该手机号码已经被注册过了 请重新注册");
                return gson.toJson(map);
            }
            try {
                TUser user=new TUser();
                user.setTelephone(telephoneNumber);
                user.setUserName(userName);
                user.setPassword(password);
                userService.save(user);
                map.put("success",true);
                registerCheck.remove(telephoneNumber);
            }catch (Exception e){
                map.put("errorMsg",e.getMessage());
                e.printStackTrace();
            }
        }else{
            //校验码验证失败
            map.put("errorMsg","校验码验证失败，请重新验证");
        }
        return gson.toJson(map);
    }


    /**
     *  登陆账号通过手机校验码
     * http://localhost:8080/tuser/loginUserByCheckNum?telephoneNumber=13072783289&checknum=4035
     * @param telephoneNumber 手机号码
     * @param checknum 校验码
     * @return 返回json对象
     */
    @RequestMapping(value = "/loginUserByCheckNum",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String loginUserByCheckNum(@RequestParam("telephoneNumber") String telephoneNumber,
                                      @RequestParam("checknum") String checknum){
        log.info(telephoneNumber+" "+checknum);
        Map map=new HashMap<>();
        if(!userService.isLoginByUserTelehoneNumber(telephoneNumber)){
            //
            map.put("errorMsg","该手机号码还没有注册号码不能登陆");
            return gson.toJson(map);
        }

        if(checknum.equals(loginCheck.get(telephoneNumber))){
            //校验码成功
            map.put("success",true);
        }else{
            //校验码失败
            map.put("errorMsg","校验码验证失败，请重新验证");
        }
        return gson.toJson(map);
    }


    /**
     * 注册账号通过手机校验码
     * http://localhost:8080/tuser/registerUserByCheckNum?telephoneNumber=13072783289&checknum=4035
     * @param telephoneNumber 手机号码
     * @param checknum 校验码
     * @return 返回json对象
     */
    @RequestMapping(value = "/registerUserByCheckNum",
            produces = "application/json;charset=UTF-8")
    @ResponseBody public String registerUserByCheckNum(@RequestParam("telephoneNumber") String telephoneNumber,
                                                    @RequestParam("checknum") String checknum,HttpServletRequest request){
        log.info(telephoneNumber+" "+checknum);
        Map map=new HashMap<>();
        HttpSession session = request.getSession();
        if(userService.isLoginByUserTelehoneNumber(telephoneNumber)){
            map.put("errorMsg","该手机号已注册");
            return gson.toJson(map);
        }
        if(checknum.equals(registerCheck.get(telephoneNumber))){
            //校验码成功
            try {
                TUser user=new TUser();
                user.setWechatId(1);
                user.setUserName("newUser");
                user.setTelephone(telephoneNumber);
                userService.save(user);
                map.put("success",true);
                registerCheck.remove(telephoneNumber);
                session.setAttribute("userID",user.getId());
            }catch (Exception e) {
                map.put("errorMsg", e.getMessage());
                e.printStackTrace();
            }

        }else{
            //校验码失败
            map.put("errorMsg","校验码验证失败，请重新验证");
        }
        return gson.toJson(map);

    }

    /**
     * 测试登录
     * http://localhost:8080/tuser/loginTest?telephoneNumber=13072783289
     * @param telephoneNumber 手机号码
     * @return 返回json对象
     */
    @RequestMapping(value = "/loginTest",
            produces = "application/json;charset=UTF-8")
    @ResponseBody public boolean loginTest(@RequestParam("telephoneNumber") String telephoneNumber,HttpServletRequest request){

        HttpSession session = request.getSession();
        Map map=new HashMap<>();
        TUser user = userService.loginTest(telephoneNumber);
        if(user != null) {
            session.setAttribute("userID",user.getId());
            return true;
        }
            return false;
    }

    /**
     * 从session获取用户信息
     * http://localhost:8080/tuser/getUser
     * @return 返回json对象
     */
    @RequestMapping(value = "/getUser",
            produces = "application/json;charset=UTF-8")
    @ResponseBody public String loginTest(HttpServletRequest request){
        Map map=new HashMap<>();
        HttpSession session = request.getSession();
        java.lang.Object userID = session.getAttribute("userID");
        if(userID != null) {
            TUser user = userService.get(Integer.parseInt(userID.toString()));
            map.put("userName", user.getUserName());
            map.put("avatar", user.getPicture());
            map.put("return",true);
        }
        else
            map.put("return",false);
        return gson.toJson(map);
    }
}
