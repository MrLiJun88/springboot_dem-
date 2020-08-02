package com.njcit.springboot_demo.servlet;

import com.njcit.springboot_demo.mapper.DepartmentMapper;
import com.njcit.springboot_demo.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LiJun
 * @Date: 2020/8/2 4:34 下午
 */
@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    /**
     * 获取所有部门信息
     * @return
     */
    public List<Department> getDepartments(){
        return departmentMapper.getDepartments();
    }
}
