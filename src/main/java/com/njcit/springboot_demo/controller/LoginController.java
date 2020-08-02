package com.njcit.springboot_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    /**
     * 登陆功能
     * @param username
     * @param password
     * @param model
     * @param request
     * @return
     */
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

    /**
     * 注销功能,session失效
     * @return
     */
    @GetMapping(value = "/user/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/index";
    }
}