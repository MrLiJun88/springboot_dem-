package com.njcit.springboot_demo.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: LiJun
 * @Date: 2020/7/31 3:03 下午
 *
 * 定义登陆拦截器
 */

public class LoginHandlerInterceptor implements HandlerInterceptor {


    /**
     * 拦截未登陆的用户访问后台
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        /**获取session中先存放的用户*/
        String user = (String) request.getSession().getAttribute("user");

        if(StringUtils.isEmpty(user)){
            request.setAttribute("msg","没有登陆权限，请先登陆");
            request.getRequestDispatcher("/index").forward(request,response);
            return false;
        }
        return true;
    }
}
