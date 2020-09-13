package com.liangxionghua.sporthealth.controller;

import com.alibaba.fastjson.JSON;
import com.liangxionghua.sporthealth.bean.QueryInfo;
import com.liangxionghua.sporthealth.bean.User;
import com.liangxionghua.sporthealth.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/alluser")
    public String getUserList(QueryInfo queryInfo) {
        int userCounts = userDao.getUserCounts("%" + queryInfo.getQuery() + "%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();

        List<User> allUser = userDao.getAllUser("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("userCounts", userCounts);
        res.put("data", allUser);
        String s = JSON.toJSONString(res);
        System.out.println(s);
        return s;
    }

    @RequestMapping("/updateuserstate")
    public String updateUserState(@RequestParam("id")Integer id, @RequestParam("state") Boolean state) {
        int i = userDao.updateState(id, state);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/adduser")
    public String addUser(@RequestBody User user) {
        user.setRole("普通用户");
        user.setState(false);
        int i = userDao.addUser(user);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/deleteuser")
    public String deleteUser(@RequestParam("id")Integer id) {
        int i = userDao.deleteUser(id);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/getupdateuser")
    public String getUpdateUser(@RequestParam("id")Integer id) {
        User updateUser = userDao.getUpdateUser(id);
        String s = JSON.toJSONString(updateUser);
        return s;
    }

    @RequestMapping("/updateuser")
    public String updateUser(@RequestBody User user) {
        int i = userDao.updateUser(user);
        return i > 0 ? "success" : "error";
    }
}
