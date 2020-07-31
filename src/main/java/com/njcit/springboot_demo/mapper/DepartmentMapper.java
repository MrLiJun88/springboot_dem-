package com.njcit.springboot_demo.mapper;

import com.njcit.springboot_demo.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @Author: LiJun
 * @Date: 2020/7/30 10:16 下午
 */
@Repository
public class DepartmentMapper {

    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<>();
        departments.put(101,new Department(101,"后勤部"));
        departments.put(102,new Department(102,"教育部"));
        departments.put(103,new Department(103,"食堂部"));
        departments.put(104,new Department(104,"操场部"));
        departments.put(105,new Department(105,"宿舍部"));
        departments.put(106,new Department(106,"教室部"));
    }

    public Collection<Department> getDepartments(){
        return departments.values();
    }

    public Department getDepartmentById(Integer departId){
        return departments.get(departId);
    }
}
