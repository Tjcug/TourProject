package com.tour.util;

import com.tour.model.TUser;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("jsonUtil")
public class JsonUtil {

    //TUSer json 转换 //
    public Map fromTUser(TUser tUser){
        Map map =new HashMap();
//        map.put("id",tUser.getId());
//        map.put("userName",tUser.getUserName());
//        map.put("email",tUser.getEmail());
//        map.put("password",tUser.getPassword());
//        map.put("sex",tUser.getSex());
//        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        map.put("birthday",format.format(tUser.getBirthday()));
//        map.put("picture",tUser.getPicture());
//        map.put("country",tUser.getCountry());
//        map.put("city",tUser.getCity());
//        map.put("creditcard",tUser.getCreditcard());
//        map.put("telephone",tUser.getTelephone());
//        map.put("score",tUser.getScore());
//        map.put("time",tUser.getTime());
//        map.put("pushnotifcation",tUser.isPushnotifcation());
//        map.put("longitude",tUser.getLongitude());
//        map.put("latitude",tUser.getLatitude());
        return map;
    }

    public List<Map> fromTUserList(List<TUser> users){
        List<Map> mapList=new ArrayList<>();
        for(TUser user:users){
            mapList.add(fromTUser(user));
        }
        return mapList;
    }
}
