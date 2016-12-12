package com.tour.controller;

import com.tour.model.TJyquestions;
import com.tour.model.TJyquestionsimage;
import com.tour.service.impl.TJyQuestionsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by panpan on 2016/12/12.
 */


@Controller
@Transactional(propagation= Propagation.REQUIRED)
@RequestMapping("/tjiying")
public class TJiyingController extends BaseController {
    /**
     * 获取从lastID后一个ID开始后面count个及应提问（按创建时间排序）
     * http://localhost:8080/tjiying/getJyQuestions?lastID=3&count=3    (如果id按时间排序，那么应该获取到id为4,5,6的提问及应)
     * @param lastID 上一次获取的最后一个及应提问id（本次从lastID后一个开始）
     * @param count 获取的数量
     * @return 返回json对象
     */
    @RequestMapping(value = "/getJyQuestions",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getJyQuestions(@RequestParam("lastID") int lastID,
                            @RequestParam("count") int count){
        Map map=new HashMap<>();
        List<TJyquestions> jyQuestionList = tJyQuestionsService.queryCount(lastID,count);

        if (jyQuestionList.size() != 0) {
            for (TJyquestions jyQuestion : jyQuestionList) {
                //用户信息
                map.put("userName",jyQuestion.getTUser().getUserName());
                map.put("headImage",jyQuestion.getTUser().getPicture());
                //如果有地理位置
                if(jyQuestion.getLatitude() != 0.0 && jyQuestion.getLongitude() != 0.0){
                    //在这里把坐标转化为地点
                    //
                    map.put("place","纽约ABC大街123号");
                }
                //如果有图片
                TJyquestionsimage jyquestionsimage = tJyQuestionsImageService.getByQuestionID((int) jyQuestion.getId());
                if(jyquestionsimage != null)
                    map.put("imagePack", jyquestionsimage.getImagePack());
                //基本信息
                map.put("creatTime", jyQuestion.getCreateTime());
                map.put("reward", jyQuestion.getReward());
                map.put("content", jyQuestion.getContent());
            }
            map.put("return","success");
        }
        else
            map.put("return","error");
        return gson.toJson(map);
    }


    /**
     * 获取指定id的及应问题
     * http://localhost:8080/tjiying/getJyQuestion?id=1
     * @param id 需要获取及应提问的id
     * @return 返回json对象
     */
    @RequestMapping(value = "/getJyQuestion",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getJyQuestion(@RequestParam("id") int id){
        Map map=new HashMap<>();
        TJyquestions jyquestions = tJyQuestionsService.get(id);
        if(jyquestions != null){
            //用户信息
            map.put("userName",jyquestions.getTUser().getUserName());
            map.put("headImage",jyquestions.getTUser().getPicture());
            map.put("phone",jyquestions.getTUser().getTelephone());
            map.put("praise",jyquestions.getTUser().getScore());
            //如果有地理位置
            if(jyquestions.getLatitude() != 0.0 && jyquestions.getLongitude() != 0.0){
                //在这里把坐标转化为地点
                //
                map.put("place","纽约ABC大街123号");
            }
            //如果有图片
            List<TJyquestionsimage> listJyquestionsimage = tJyQuestionsImageService.getAllByQuestionID((int) jyquestions.getId());
            if(listJyquestionsimage.size() != 0)
                map.put("imagePack", listJyquestionsimage.toArray());
            //基本信息
            map.put("creatTime", jyquestions.getCreateTime());
            map.put("reward", jyquestions.getReward());
            map.put("content", jyquestions.getContent());
            map.put("return","success");
        }
        else
            map.put("return","error");
        return gson.toJson(map);
    }

    /**
     * 发布及应问题
     * http://localhost:8080/tjiying/addJyQuestion?content="求帮点菜，两人份不吃辣，附上菜单"&images=xxxxx
     * @param content 提问内容
     * @param reward 赏金
     * @param latitude 经度
     * @param longitude 维度
     * @param images 上传的图片数组（如果有）
     * @return 返回json对象
     */
    @RequestMapping(value = "/addJyQuestion",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addJyQuestion(@RequestParam("content") int content,
                                @RequestParam("reward") int reward,
                                @RequestParam("latitude") String latitude,
                                @RequestParam("longitude") String longitude,
                                @RequestParam("images")MultipartFile images[]){
        Map map=new HashMap<>();

        //如果上传了图片
        if(images.length != 0){

        }

        //如果上传了位置
        if(latitude != null && longitude != null ){

        }


        return null;
    }



    /**
     * 回答指定id的及应问题
     * http://localhost:8080/tjiying/answerJyQuestion?id=1
     * @param id 回答及应提问的id
     * @return 返回json对象
     */
    @RequestMapping(value = "/answerJyQuestion",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public boolean answerJyQuestion(@RequestParam("id") int id){

        return false;
    }

    /**
     * 添加回答内容（或追问内容）到指定id的及应回答
     * http://localhost:8080/tjiying/addJyAnserContent?id=1&type=1&content="再多点两份菜，又多来了一小伙伴"
     * @param id 及应回答的id
     * @param type 0为回答，1为追问
     * @param content 回答内容（或追问内容）
     * @return 返回json对象
     */
    @RequestMapping(value = "/addJyAnserContent",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addJyAnserContent(@RequestParam("id") int id,
                                    @RequestParam("type") int type,
                                    @RequestParam("content") String content){
        Map map=new HashMap<>();
        return null;
    }

    /**
     * 获取已解决的及应
     * http://localhost:8080/tjiying/getSettlementJyQuestions
     * @param type 0为自己解决别人的及应，1为自己发布的及应（已解决的）
     * @param count 获取的数量
     * @return 返回json对象
     */
    @RequestMapping(value = "/getSettlementJyQuestions",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getSettlementJyQuestions(@RequestParam("type") int type,
                                 @RequestParam("count") int count){
        Map map=new HashMap<>();
        return null;
    }


}
