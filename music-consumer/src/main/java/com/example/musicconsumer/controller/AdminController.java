package com.example.musicconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.musicapi.service.AdminService;
import com.example.musicconsumer.common.FailMessage;
import com.example.musicconsumer.common.SuccessMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class AdminController {
    @Reference(check = false)
    private  AdminService adminService;
    // 判断是否登录成功
    @ResponseBody
    @RequestMapping(value = "/admin/login/status", method = RequestMethod.POST)
    public Object loginStatus(HttpServletRequest req, HttpSession session) {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        boolean res = adminService.veritypasswd(name, password);
        if (res) {
            session.setAttribute("name", name);
            return new SuccessMessage("登录成功").getMessage();
        } else {
            return new FailMessage("用户名或密码错误").getMessage();
        }

    }
}
