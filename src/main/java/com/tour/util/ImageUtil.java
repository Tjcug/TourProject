package com.tour.util;

import com.tour.model.TJyanswerscontent;
import com.tour.model.TJyanswerscontentimage;
import com.tour.model.TJyquestions;
import com.tour.model.TJyquestionsimage;
import com.tour.service.TJyAnswersImageService;
import com.tour.service.TJyQuestionsImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("#{prop.uploadFile}")
    private String filePath;

    @Value("#{prop.ipaddress}")
    private String ipaddress;

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
        String imagePack =filePath+"/1/"+data1+'/'+data2;
        String ipdressImagepack=ipaddress+"/1/"+data1+'/'+data2;
        for (int i = 0;i<images.length;i++) {
            //获取图片名称的后缀
            String imageName = images[i].getOriginalFilename();
            String imageFix = imageName.substring(imageName.lastIndexOf('.')+1);
            try {
                //图片存储
                String fileName=ipdressImagepack+"/"+i+"."+imageFix;
                uploadFile(images[i],imagePack,i+"."+imageFix);

                //数据储存图片的记录
                TJyquestionsimage jyquestionsimage = new TJyquestionsimage();
                jyquestionsimage.setTJyquestions(jyquestions);
                jyquestionsimage.setImagePack(fileName);
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
     *
     */
    public void uploadMultipartFilesJyAnswerContent(MultipartFile images[],
                                                    TJyanswerscontent jyanswerscontent){
        String data1 = (new SimpleDateFormat("yyyyMMdd")).format(new Date());
        String data2 = (new SimpleDateFormat("HHmmss")).format(new Date());
        String imagePack =filePath+"/2/"+data1+'/'+data2;
        String ipdressImagepack=ipaddress+"/2/"+data1+'/'+data2;
        for (int i = 0;i<images.length;i++) {
            //储存图片
            //获取图片名称的后缀
            String imageName = images[i].getOriginalFilename();
            String imageFix = imageName.substring(imageName.lastIndexOf('.')+1);
            try {
                //图片存储
                String fileName=ipdressImagepack+"/"+i+"."+imageFix;
                uploadFile(images[i],imagePack,i+"."+imageFix);

                //数据储存图片的记录
                TJyanswerscontentimage tJyanswerscontentimage=new TJyanswerscontentimage();
                tJyanswerscontentimage.setImagePack(fileName);
                tJyanswerscontentimage.setCreateTime(new Date());
                tJyanswerscontentimage.setTJyanswerscontent(jyanswerscontent);
                tJyAnswersImageService.save(tJyanswerscontentimage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void uploadFile(MultipartFile image,String fileDir,String fileName) throws IOException {
        //图片储存
        File file= new File(fileDir);
        //如果目录不存在就创建目录
        if (!file.exists())
            file.mkdirs();
        String imagePack=fileDir+"/"+fileName;
        image.transferTo(new File(imagePack));
    }
}
