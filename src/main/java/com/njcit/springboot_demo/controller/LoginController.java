package com.njcit.springboot_demo.controller;

import com.njcit.springboot_demo.pojo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: LiJun
 * @Date: 2020/7/31 2:20 下午
 *
 * 登陆Controller
 */
@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, Model model, HttpServletRequest request){

        if(!StringUtils.isEmpty(username) && "hello".equals(password)){
            /**登陆成功*/
            HttpSession session = request.getSession();
            /**将登陆成功的用户存入session*/
            session.setAttribute("user",username);
            return "redirect:/main";
        }
        else{
            model.addAttribute("msg","用户名或者密码错误");
            return "index";
        }
    }
}