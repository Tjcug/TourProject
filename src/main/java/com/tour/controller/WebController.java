package com.tour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dell-pc on 2016/4/22.
 */

@Controller
public class WebController extends BaseController{

    @RequestMapping(value = "/manage")
    public String index(){
        return mainPath+"aindex";
    }

    @RequestMapping(value = "/manage/login")
    public String login(){
        return mainPath+"login";
    }

    @RequestMapping(value = "/temp")
    public String temp(){
        return "temp";
    }

    @RequestMapping(value = "/uploadftl")
    public String upload(){
        log.info("abcdefg");
        return "upload";
    }

    /**
     * 页面转发控制器 两个参数
     * @param var1
     * @param var2
     * @return
     */
    @RequestMapping("/manage_{var1}_{var2}")
    public String sendFunc(@PathVariable("var1") String var1, @PathVariable("var2") String var2){
        return mainPath+var1+"/"+var2;
    }

    //微信主页面
    @RequestMapping(value = "/wechat")
    public String wechatIndex(){
        return wechatPath+"index";
    }

    /**
     * 微信一级页面转发控制器
     * @param var1
     * @return
     */
    @RequestMapping("/wechat/{var1}")
    public String sendMain(@PathVariable("var1") String var1){
        return wechatPath+var1;
    }

    /**
     * 微信二级级页面转发控制器
     * @param dir
     * @param file
     * @return
     */
    @RequestMapping("/wechat/{dir}/{file}")
    public String sendMainDir(@PathVariable("dir") String dir,@PathVariable("file") String file){
        return wechatPath+dir+"/"+file;
    }
}
