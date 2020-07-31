package com.njcit.springboot_demo.controller;

import com.njcit.springboot_demo.mapper.EmployeeMapper;
import com.njcit.springboot_demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @Author: LiJun
 * @Date: 2020/7/31 3:47 下午
 */

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 获取所有员工
     * @param model
     * @return
     */
    @GetMapping(value = "/emplist")
    public String empList(Model model){
        Collection<Employee> empList = employeeMapper.getAll();
        model.addAttribute("emps",empList);
        return "emp/list";
    }

    /**
     * 添加新员工
     * @return
     */
    @GetMapping(value = "/addemp")
    public String addEmp(){
        return "emp/add";
    }
}
