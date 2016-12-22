package com.tour.controller;

import com.tour.model.*;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by panpan on 2016/12/12.
 */


@Controller
@Transactional(propagation = Propagation.REQUIRED)
@RequestMapping("/tjiying")
public class TJiyingController extends BaseController {

    /**
     * 获取未解决的及应数量
     * http://localhost:8080/tjiying/getJyQuestionsCount
     *
     * @return 返回json对象
     */
    @RequestMapping(value = "/getJyQuestionsCount",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public int getJyQuestionsCount() {
        return jyQuestionsService.getCount();
    }

    /**
     * 获取从lastID后一个ID开始后面count个及应提问（按创建时间排序）
     * http://localhost:8080/tjiying/getJyQuestions?lastID=3&count=3    (如果id按时间排序，那么应该获取到id为4,5,6的提问及应)
     *
     * @param lastID 上一次获取的最后一个及应提问id（本次从lastID后一个开始）
     * @param count  获取的数量
     * @return 返回json对象
     */
    @RequestMapping(value = "/getJyQuestions",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getJyQuestions(@RequestParam("lastID") int lastID,
                                 @RequestParam("count") int count) {
        Map map = new HashMap<>();
        List<TJyquestions> jyQuestionList = jyQuestionsService.getCountJy(lastID, count);
        int size = jyQuestionList.size();
        Map rows[] = new Map[size];
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                TJyquestions jyQuestion = jyQuestionList.get(i);
                rows[i] = new HashMap<>();
                //用户信息
                rows[i].put("userName", jyQuestion.getTUser().getUserName());
                String headImage = jyQuestion.getTUser().getPicture() == null ? null : jyQuestion.getTUser().getPicture();
                rows[i].put("avatar", headImage);
                //如果有地理位置
                if (jyQuestion.getLatitude() != 0.0 && jyQuestion.getLongitude() != 0.0) {
                    //在这里把坐标转化为地点
                    //
                }
                rows[i].put("place", "纽约ABC大街123号");
                //如果有图片
                List<TJyquestionsimage> listJyquestionsimage = jyQuestionsImageService.getByQuestionID(jyQuestion.getId(), 0);
                if (listJyquestionsimage.size() != 0)
                    rows[i].put("imagePack", listJyquestionsimage.get(0).getImagePack());
                //基本信息
                rows[i].put("id", jyQuestion.getId());
                rows[i].put("creatTime", new SimpleDateFormat("MM月dd日 HH:mm").format(jyQuestion.getCreateTime()));
                rows[i].put("reward", jyQuestion.getReward());
                rows[i].put("content", jyQuestion.getContent());
            }
            map.put("data", rows);
            map.put("return", "success");
        } else
            map.put("return", "error");
        return gson.toJson(map);
    }


    /**
     * 获取指定id的及应问题(图片用下一个方法获取)
     * http://localhost:8080/tjiying/getJyQuestion?id=1
     *
     * @param id 需要获取及应提问的id
     * @return 返回json对象
     */
    @RequestMapping(value = "/getJyQuestion",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelAndView getJyQuestion(@RequestParam("id") int id,
                                      HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView("/wechat/jy_detail");
        TJyquestions jyQuestion = jyQuestionsService.get(id);
        if (jyQuestion != null) {
            //用户信息
            modelAndView.addObject("userName", jyQuestion.getTUser().getUserName());
            modelAndView.addObject("avatar", jyQuestion.getTUser().getPicture());
            modelAndView.addObject("phone", jyQuestion.getTUser().getTelephone());
            modelAndView.addObject("praise", jyQuestion.getTUser().getScore());
            //如果有地理位置
            if (jyQuestion.getLatitude() != 0.0 && jyQuestion.getLongitude() != 0.0) {
                //在这里把坐标转化为地点
                modelAndView.addObject("place", "纽约ABC大街123号");
            }
            //基本信息
            modelAndView.addObject("id", jyQuestion.getId());
            modelAndView.addObject("creatTime", jyQuestion.getCreateTime());
            modelAndView.addObject("reward", jyQuestion.getReward());
            modelAndView.addObject("content", jyQuestion.getContent());
            modelAndView.addObject("return", "success");
            //用户session信息(解答时需要传入)
            HttpSession session = request.getSession();
            TUser user = (TUser) session.getAttribute("user");
            modelAndView.addObject("userID", user.getId());
        } else
            modelAndView.addObject("return", "error");
        return modelAndView;
    }

    /**
     * 获取指定id的及应问题的图片
     * http://localhost:8080/tjiying/getJyQuestionImages?id=1
     *
     * @param id 需要获取及应提问的id
     * @return 返回json对象
     */
    @RequestMapping(value = "/getJyQuestionImages",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getJyQuestionImages(@RequestParam("id") int id) {
        Map map = new HashMap<>();
        try {
            //图片
            List<TJyquestionsimage> listJyquestionsimage = jyQuestionsImageService.getByQuestionID(id, 1);
            int size = listJyquestionsimage.size();
            Map images[] = new Map[size];
            for (int i = 0; i < size; i++) {
                images[i] = new HashMap<>();
                images[i].put("imagePack", listJyquestionsimage.get(i).getImagePack());
            }
            map.put("images", images);
            map.put("success", true);
        } catch (Exception e) {
            map.put("errorMsg", e.getMessage());
            e.printStackTrace();
        }
        return gson.toJson(map);
    }

    /**
     * 发布及应问题,图片地址储存为uploads/images/type/yyyyMMdd/HHmmss.后缀名
     * http://localhost:8080/tjiying/addJyQuestion?content="求帮点菜，两人份不吃辣，附上菜单"&images=xxxxx
     *
     * @param content   提问内容
     * @param reward    赏金
     * @param latitude  经度
     * @param longitude 维度
     * @param images    上传的图片数组（如果有）
     * @return 返回json对象
     */
    @RequestMapping(value = "/addJyQuestion",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public boolean addJyQuestion(@RequestParam("content") String content,
                                 @RequestParam("reward") int reward,
                                 @RequestParam("latitude") double latitude,
                                 @RequestParam("longitude") double longitude,
                                 @RequestParam(value = "images", required = false) MultipartFile images[],
                                 HttpServletRequest request) {

        TJyquestions jyquestions = new TJyquestions();
        //从session中获取用户信息
        HttpSession session = request.getSession();
        jyquestions.setTUser((TUser) session.getAttribute("user"));
        //基本信息
        jyquestions.setContent(content);
        jyquestions.setReward(reward);
        jyquestions.setCreateTime(new Date());
        byte state = 0;
        jyquestions.setState(state);
        jyquestions.setLatitude(0.0);
        jyquestions.setLongitude(0.0);
        //如果上传了位置
        if (latitude != 0.0 && longitude != 0.0) {
            jyquestions.setLatitude(latitude);
            jyquestions.setLongitude(longitude);
        }
        jyQuestionsService.save(jyquestions);
        //如果上传了图片
        if (images.length != 0) {
            imageUtil.uploadMultipartFilesJyquestions(images, jyquestions);
            return true;
        }
        return true;
    }

    /**
     * http://localhost:8080/tjiying/addJyAnswer?id=1&userid=58
     * 添加即应Answer表让回答问题用户和问问题用户建立联系
     *
     * @param id     问题的id
     * @param userID 回答问题用户的id
     * @return 返回json对象
     */
    @RequestMapping(value = "/addJyAnswer",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addJyAnswer(@RequestParam("id") int id,
                              @RequestParam("userid") int userID) {
        Map map = new HashMap<>();

        try {
            if (jyQuestionsService.isQuestionUser(id, userID)) {
                map.put("errorMsg", "您可不能解答自己的及应啊！");
                return gson.toJson(map);
            }

            long answerID = jyAnswersService.addJyAnswerByQuestionsidAndUserId(id, userID);
            //更新问题表改变问题状态
            jyQuestionsService.nowSolveProblem(id);

            map.put("answerID", answerID);
            map.put("success", true);
        } catch (Exception e) {
            map.put("errorMsg", e.getMessage());
            e.printStackTrace();
        }

        return gson.toJson(map);
    }

    /**
     * 添加回答内容（或追问内容）到指定id的及应回答
     * http://localhost:8080/tjiying/addJyAnserContent?id=1&type=false&content="再多点两份菜，又多来了一小伙伴"&userid=31
     * http://localhost:8080/tjiying/addJyAnserContent?id=1&type=false&content=又多来了两个小伙伴&userid=58
     *
     * @param id      及应回答的id
     * @param userid  回答问题的用户id 可能是回答问题者 也可能是问问题的人
     * @param type    0(false)为回答，1(true)为追问
     * @param content 回答内容（或追问内容）
     * @return 返回json对象
     */
    @RequestMapping(value = "/addJyAnserContent",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addJyAnserContent(@RequestParam("id") int id,
                                    @RequestParam("userid") int userid,
                                    @RequestParam("type") boolean type,
                                    @RequestParam("content") String content,
                                    @RequestParam(value = "images", required = false) MultipartFile images[]) {
        Map map = new HashMap<>();

        try {
            TJyanswers tJyanswers = new TJyanswers();
            //判断userid和questionid组成的键值对 数据库中是否有记录 反正添加重复记录
            boolean bool = jyAnswersService.isAnswersByUseridAndQuestionsid(userid, id);
            if (!bool) {
                //如果没有记录 就先放入一条新的纪录
                //存储回答问题的记录
                jyAnswersService.addJyAnswerByQuestionsidAndUserId(id, userid);
            }
            //存储回答问题内容的记录
            TJyanswerscontent jyanswerscontent = new TJyanswerscontent();
            jyanswerscontent.setCreateTime(new Date());
            jyanswerscontent.setContent(content);
            jyanswerscontent.setTUser(userService.get(userid));
            jyanswerscontent.setType(type);

            if (!bool)
                jyanswerscontent.setTJyanswers(tJyanswers);
            else
                jyanswerscontent.setTJyanswers(jyAnswersService.findAnswerByUseridAndQuestionid(userid, id));
            jyAnswersContentService.save(jyanswerscontent);

            //如果上传了图片
            if (images.length != 0) {
                imageUtil.uploadMultipartFilesJyAnswerContent(images, jyanswerscontent);
            }
            map.put("success", true);
        } catch (Exception e) {
            map.put("errorMsg", e.getMessage());
            e.printStackTrace();
        }
        return gson.toJson(map);
    }

    /**
     * 即应 给相互两位用户来评分
     * http://localhost:8080/tjiying/markScoreToUser?answerid=3&userid=31&score=3.8
     * http://localhost:8080/tjiying/markScoreToUser?answerid=3&userid=58&score=4.6
     *
     * @param answerid 回答问题id
     * @param userid   被评分的用户id
     * @return 返回json对象
     */
    @RequestMapping(value = "/markScoreToUser",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String markScoreToUser(@RequestParam("answerid") int answerid,
                                  @RequestParam("userid") int userid,
                                  @RequestParam("score") double score) {
        Map map = new HashMap<>();

        try {
            TJyanswers tJyanswers = jyAnswersService.get(answerid);
            TJyquestions tJyquestions = tJyanswers.getTJyquestions();
            long questionsUserid = tJyquestions.getTUser().getId();
            if (questionsUserid == userid) {
                //如果是说明是提出问题的人给回答这个answer的用户评分
                tJyanswers.setFromuserscore(score);
            } else {
                //如果不是说明是回答这个answer的用户给提出问题的人评分
                tJyanswers.setTouserscore(score);
            }
            jyAnswersService.update(tJyanswers);
            map.put("success", true);
        } catch (Exception e) {
            map.put("errorMsg", e.getMessage());
            e.printStackTrace();
        }

        return gson.toJson(map);
    }

    /**
     * 用户觉得成功解决问题
     * http://localhost:8080/tjiying/successSolveProblem?answerid=3&questionid=1
     *
     * @param answerid   回答问题的id
     * @param questionid 问题的id
     * @return 返回json对象
     */
    @RequestMapping(value = "/successSolveProblem",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String successSolveProblem(@RequestParam("answerid") int answerid,
                                      @RequestParam("questionid") int questionid) {
        Map map = new HashMap<>();

        try {
            jyAnswersService.successSolveProblem(answerid);
            jyQuestionsService.successSolveProblem(questionid);
            map.put("success", true);
        } catch (Exception e) {
            map.put("errorMsg", e.getMessage());
            e.printStackTrace();
        }

        return gson.toJson(map);
    }


    /**
     * 正在解决问题
     * http://localhost:8080/tjiying/nowSolveProblem?answerid=3&questionid=1
     *
     * @param answerid   回答者的id
     * @param questionid 问题的id
     * @return 返回json对象
     */
    @RequestMapping(value = "/nowSolveProblem",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String nowSolveProblem(@RequestParam("answerid") int answerid,
                                  @RequestParam("questionid") int questionid) {
        Map map = new HashMap<>();

        try {
            jyAnswersService.nowSolveProblem(answerid);
            jyQuestionsService.nowSolveProblem(questionid);
            map.put("success", true);
        } catch (Exception e) {
            map.put("errorMsg", e.getMessage());
            e.printStackTrace();
        }

        return gson.toJson(map);
    }

    /**
     * 用户觉得没有成功解决问题,或者答题者放弃回答
     * http://localhost:8080/tjiying/failSolveProblem?answerid=3&questionid=1
     *
     * @param answerid   回答问题的id
     * @param questionid 问题的id
     * @return 返回json对象
     */
    @RequestMapping(value = "/failSolveProblem",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String failSolveProblem(@RequestParam("answerid") int answerid,
                                   @RequestParam("questionid") int questionid) {
        Map map = new HashMap<>();

        try {
            jyAnswersService.failSolveProblem(answerid);
            jyQuestionsService.failSolveProblem(questionid);
            map.put("success", true);
        } catch (Exception e) {
            map.put("errorMsg", e.getMessage());
            e.printStackTrace();
        }

        return gson.toJson(map);
    }

    /**
     * 获取已解决的及应
     * http://localhost:8080/tjiying/getSettlementJyQuestions?type=0&index=0&count=5
     *
     * @param type  0为自己解决别人的及应，1为自己发布的及应（已解决的）
     * @param index 需要跳过的及应数
     * @param count 获取的数量
     * @return 返回json对象
     */
    @RequestMapping(value = "/getSettlementJyQuestions",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getSettlementJyQuestions(@RequestParam("type") int type,
                                           @RequestParam("index") int index,
                                           @RequestParam("count") int count) {
        Map map = new HashMap<>();
        //获取当前用户的id
        int userID = 31;
        List<TJyquestions> jyQuestionList = jyQuestionsService.getUserJy(userID, type, index, count);
        if (jyQuestionList != null) {
            int size = jyQuestionList.size();
            Map rows[] = new Map[size];
            if (size != 0) {
                for (int i = 0; i < size; i++) {
                    rows[i] = new HashMap<>();
                    TJyquestions jyQuestion = jyQuestionList.get(i);
                    //用户信息
                    rows[i].put("userName", jyQuestionList.get(i).getTUser().getUserName());
                    rows[i].put("headImage", jyQuestion.getTUser().getPicture());
                    //如果有地理位置
                    if (jyQuestion.getLatitude() != 0.0 && jyQuestion.getLongitude() != 0.0) {
                        //在这里把坐标转化为地点
                        map.put("place", "纽约ABC大街123号");
                    }
                    //如果有图片
                    List<TJyquestionsimage> listJyquestionsimage = jyQuestionsImageService.getByQuestionID(jyQuestion.getId(), 0);
                    if (listJyquestionsimage.size() != 0)
                        map.put("imagePack", listJyquestionsimage.get(0).getImagePack());
                    //基本信息
                    rows[i].put("creatTime", jyQuestion.getCreateTime());
                    rows[i].put("reward", jyQuestion.getReward());
                    rows[i].put("content", jyQuestion.getContent());
                }
                map.put("data", rows);
                map.put("return", "success");
            } else
                map.put("return", "error");
        }
        return gson.toJson(map);
    }
}
