package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.Impl.Impl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Validated
@RestController//接口的入口
@RequestMapping("/user")
public class UserController {
    private final Impl impl;

    public UserController(Impl impl) {
        this.impl = impl;
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest  request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        impl.registerInsert(username,password);
        return "恭喜您，注册成功";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest  request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        User users= impl.loginSelect(username,password);
        if(users!=null)
        {
            return "恭喜您，登录成功";
        }else{
            return  "您的用户名或输入密码有误";
        }
    }
    @RequestMapping("/update")
    public String update(HttpServletRequest  request){
        String username=request.getParameter("username");
        int id=Integer.parseInt(request.getParameter("id"));
        boolean users= impl.updateUserById(username,id);
        if(users)
        {
            return "修改成功~";
        }else{
            return "用户不存在，请重新输入";
        }
    }
    @RequestMapping("/delete")
    public String delete(HttpServletRequest  request){
        int id=Integer.parseInt(request.getParameter("id"));
        impl.deleteUerById(id);
        return "已删除该用户或该用户不存在";
    }
    @RequestMapping("/select")
    public String select(HttpServletRequest  request){
        int id=Integer.parseInt(request.getParameter("id"));
        String username= impl.getUserById(id);
        if(username!=null)
        {
            return "该用户名为："+username;
        }else{
            return "该用户不存在";
        }
    }
}
