package com.staff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.staff.pojo.User;
import com.staff.service.impl.UserService;

import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
    private UserService userService;
 
    @RequestMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session){
        if ("admin".equals( username )&& "123456".equals( password )){
            session.setAttribute( "LoginUser",username );
            return "redirect:/main.html";//重定向到main.html页面,也就是跳转到dashboard页面
        }else{
            model.addAttribute( "msg","用户名或者密码错误" );
            return "index";
        }

    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index.html";
    }
    
    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id){
        return userService.Sel(id).toString();
    }
    
    @GetMapping("find_page")
    public Object findPage(int pageNo, int pageSize){
        //设置分页信息
        PageHelper.startPage(pageNo, pageSize);
        //生成分页信息对象
        PageInfo<User> pageInfo = new PageInfo<>();
        return pageInfo;
    }
}
