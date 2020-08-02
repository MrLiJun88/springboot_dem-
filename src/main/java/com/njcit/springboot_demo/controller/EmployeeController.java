package com.njcit.springboot_demo.controller;

import com.njcit.springboot_demo.pojo.Department;
import com.njcit.springboot_demo.pojo.Employee;
import com.njcit.springboot_demo.servlet.DepartmentService;
import com.njcit.springboot_demo.servlet.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

/**
 * @Author: LiJun
 * @Date: 2020/7/31 3:47 下午
 */

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    /**
     * 获取所有员工信息
     * @param model
     * @return
     */
    @GetMapping(value = "/emplist")
    public String empList(Model model){
        Collection<Employee> empList = employeeService.getAll();
        model.addAttribute("emps",empList);
        return "emp/list";
    }

    /**
     * 添加新员工,同时获取到所有的部门信息
     * @return
     */
    @GetMapping(value = "/addemp")
    public String addEmp(Model model){
        Collection<Department> departments = departmentService.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    /**
     * 新增员工,添加成功后重定义到首页显示
     * @return
     */
    @PostMapping(value = "/saveemp")
    public String saveEmp(Employee employee){
        employeeService.save(employee);
        return "redirect:/emplist";
    }

    /**
     * 获取对应员工的信息，中转到员工的修改页面
     * @param empId
     * @return
     */
    @GetMapping(value = "/emp/{empId}")
    public String toUpdateEmp(@PathVariable(value = "empId") Integer empId,Model model){
        Employee employee = employeeService.getEmpById(empId);
        Collection<Department> departments = departmentService.getDepartments();
        model.addAttribute("employee",employee);
        /**获取所有的部门信息*/
        model.addAttribute("departments",departments);
        return "emp/update";
    }

    /**
     * 更新员工信息
     * @param employee
     * @return
     */
    @PostMapping(value = "/updateEmp")
    public String updateEmp(Employee employee){
        employeeService.update(employee);
        return "redirect:/emplist";
    }

    /**
     * 根据empId删除对应员工
     * @param empId
     * @return
     */
    @GetMapping(value = "/delemp/{empId}")
    public String delEmp(@PathVariable(value = "empId") Integer empId){
        employeeService.delete(empId);
        return "redirect:/emplist";
    }
}
