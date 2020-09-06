package com.liangxionghua.sporthealth.controller;

import com.alibaba.fastjson.JSON;
import com.liangxionghua.sporthealth.bean.User;
import com.liangxionghua.sporthealth.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/login")
    public String login(@RequestBody User user) {
        String flag = "error";
        User userByMessage = userDao.getUserByMessage(user.getUsername(), user.getPassword());
        HashMap<String, Object> res = new HashMap<>();
        if (userByMessage != null) {
            flag = "ok";
        }
        res.put("flag", flag);
        res.put("user", userByMessage);

        String res_json = JSON.toJSONString(res);
        System.out.println(res_json);
        return  res_json;
    }
}
