package com.tour.controller;

import com.google.gson.Gson;
import com.tour.service.*;
import com.tour.util.FreeMarkerUtil;
import com.tour.util.GeomUtil;
import com.tour.util.GsonUtil;
import com.tour.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dell-pc on 2016/4/21.
 */
@Controller
public class BaseController {

    //后台项目基础url
    protected String mainPath="manage/";

    @ModelAttribute("BasePath")
    public String getBasePath(HttpServletRequest httpServletRequest){
        log.info(httpServletRequest.getServletContext().getContextPath());
        return httpServletRequest.getServletContext().getContextPath();
    }

    protected Gson gson = new Gson();

    protected static final Logger log = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    protected TAssistantanswersService assistantanswersService;
    @Autowired
    protected TAssistantquestionsService assistantquestionsService;
    @Autowired
    protected TDiscusslikesService discusslikesService;
    @Autowired
    protected TDiscussService discussService;
    @Autowired
    protected TOrderService orderService;
    @Autowired
    protected TReplayService replayService;
    @Autowired
    protected TUserService userService;
    @Autowired
    protected TAdministratorService tAdministratorService;

    @Autowired
    protected GeomUtil geomUtil;
    @Autowired
    protected JsonUtil jsonUtil;
    @Autowired
    protected FreeMarkerUtil freeMarkerUtil;
    @Autowired
    protected GsonUtil gsonUtil;
}
