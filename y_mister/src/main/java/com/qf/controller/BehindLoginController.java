package com.qf.controller;

import com.qf.pojo.Admin;
import com.qf.service.BehindLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 炜哥哥
 * @date 2019/12/18 15:12
 */
@Controller
@RequestMapping("admin")
public class BehindLoginController {

    @Autowired
    private BehindLoginService behindLoginService;


    @RequestMapping("/gologin")
    public String gologin(){
        return "behind/login";
    }
    /**
     * 正常获取用户输入的用户名 和密码去数据库查询
     * @param admin
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(Admin admin){
        boolean b = behindLoginService.behindUserLogin(admin);
        if(b){
           return "success" ;
        }
        return "error";
    }

    @RequestMapping("/exit")
    public  String exit(){
    return "behind/login";
    }

}
