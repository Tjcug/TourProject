package com.tour.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by dell-pc on 2016/4/23.
 */


@Controller
public class FileUploadController extends BaseController{

    @Value("#{prop.uploadFile}")
    private String filePath;

    @RequestMapping(value = "upload",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest req){
        String filename=file.getOriginalFilename();
        log.info(filePath);
        if(!file.isEmpty()){
            try {
                file.transferTo(new File(filePath+"upload/"+file.getOriginalFilename()));
                return "You successfully uploaded " +filename  + " into " + filename + "-uploaded !";
            }catch (Exception e){
                return "You failed to upload " + filename + " => " + e.getMessage();
            }
        }else{
            return "You failed to upload " + filename + " because the file was empty.";
        }
    }

}
