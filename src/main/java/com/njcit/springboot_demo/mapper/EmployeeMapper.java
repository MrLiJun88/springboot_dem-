package com.njcit.springboot_demo.mapper;

import com.njcit.springboot_demo.pojo.Department;
import com.njcit.springboot_demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LiJun
 * @Date: 2020/7/30 10:23 下午
 */
@Repository
public class EmployeeMapper {

    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentMapper departmentMapper;

    static {
        employees = new HashMap<>();
        employees.put(1001,new Employee(1001,"wangwu","wangwu@qq.com",0,new Department(101,"后勤部")));
        employees.put(1002,new Employee(1002,"lisi","lisi@qq.com",0,new Department(102,"教育部")));
        employees.put(1003,new Employee(1003,"zhaoliu","zhaoliu@qq.com",0,new Department(103,"食堂部")));
        employees.put(1004,new Employee(1004,"lijun","lijun@qq.com",0,new Department(104,"操场部")));
        employees.put(1005,new Employee(1005,"zhaobiqiang","zhaobiqiang@qq.com",0,new Department(105,"宿舍部")));
        employees.put(1006,new Employee(1006,"haha","haha@qq.com",0,new Department(106,"教室部")));
    }

    private static Integer initId = 1007;

    /**
     * 保存和更新方法
     * @param employee
     */
    public void save(Employee employee){
        if(null == employee.getEmpId()){
            employee.setEmpId(initId++);
        }

        employee.setDepartment(departmentMapper.getDepartmentById(employee.getDepartment().getDepartId()));
        employees.put(employee.getEmpId(),employee);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee getEmpById(Integer empId){
        return employees.get(empId);
    }

    public void delete(Integer empId){
        employees.remove(empId);
    }
}
