package com.njcit.springboot_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: LiJun
 * @Date: 2020/7/5 11:35 下午
 */

@RestController
public class PersonController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello world";
    }
}
