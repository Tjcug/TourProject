package com.tour.util;

import com.tour.model.TJyanswerscontent;
import com.tour.model.TJyanswerscontentimage;
import com.tour.model.TJyquestions;
import com.tour.model.TJyquestionsimage;
import com.tour.service.TJyAnswersImageService;
import com.tour.service.TJyQuestionsImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 79875 on 2016/12/19.
 */
@Component("imageUtil")
public class ImageUtil {

    @Autowired
    protected TJyQuestionsImageService jyQuestionsImageService;

    @Autowired
    protected TJyAnswersImageService tJyAnswersImageService;

    /**
     * 即应问题上传多张图片
     * @param images 图片对象
     */
    public void uploadMultipartFilesJyquestions(MultipartFile images[], TJyquestions jyquestions){
        //图片路径
        String data1 = (new SimpleDateFormat("yyyyMMdd")).format(new Date());
        String data2 = (new SimpleDateFormat("HHmmss")).format(new Date());
        String fileDir = "/uploads/images/1/"+data1;
        String imagePack = fileDir+'/'+data2;
        for (int i = 0;i<images.length;i++) {
            //获取图片名称的后缀
            String imageName = images[i].getName();
            String imageFix = imageName.substring(imageName.lastIndexOf('.')+1);
            try {
                //图片储存
                File file= new File(fileDir);
                //如果目录不存在就创建目录
                if (!file.exists())
                    file.mkdirs();
                images[i].transferTo(new File(imagePack+"-"+i+imageFix));
                File dir = new File(fileDir);
                //数据储存图片的记录
                TJyquestionsimage jyquestionsimage = new TJyquestionsimage();
                jyquestionsimage.setTJyquestions(jyquestions);
                jyquestionsimage.setImagePack(imagePack+"-"+i);
                jyquestionsimage.setCreateTime(new Date());
                jyQuestionsImageService.save(jyquestionsimage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 即应答案上传多张图片
     * @param images 图片对象
     * @param imagePack 图片路径
     */
    public void uploadMultipartFilesJyAnswerContent(MultipartFile images[], String imagePack,
                                                    TJyanswerscontent jyanswerscontent){
        for (int i = 0;i<images.length;i++) {
            //储存图片
            //获取图片名称的后缀
            String imageName = images[i].getName();
            String imageFix = imageName.substring(imageName.lastIndexOf('.')+1);
            try {
                images[i].transferTo(new File(imagePack+"-"+i+imageFix));
                //数据储存图片的记录
                TJyanswerscontentimage tJyanswerscontentimage=new TJyanswerscontentimage();
                tJyanswerscontentimage.setImagePack(imagePack);
                tJyanswerscontentimage.setCreateTime(new Date());
                tJyanswerscontentimage.setTJyanswerscontent(jyanswerscontent);
                tJyAnswersImageService.save(tJyanswerscontentimage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
