package com.njcit.springboot_demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @Author: LiJun
 * @Date: 2020/7/31 11:22 上午
 *
 * 自定义国际化解析器
 */

public class MyLocaleResolver implements LocaleResolver {

    /**
     * 解析请求
     * @param request
     * @return
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        /**获取请求参数中的值*/
        String language = request.getParameter("lan");
        /**获取默认的国际化配置*/
        Locale locale = Locale.getDefault();
        /**如果自定义的国际化配置不为空，则使用自定义的，否则使用默认配置*/
        if(!StringUtils.isEmpty(language)){
            String[] split = language.split("_");
            String lan = split[0];
            String country = split[1];
            return new Locale(lan, country);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
