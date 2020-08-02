package com.njcit.springboot_demo.servlet;

import com.njcit.springboot_demo.mapper.EmployeeMapper;
import com.njcit.springboot_demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Author: LiJun
 * @Date: 2020/8/2 4:39 下午
 */

@Service
public class EmployeeService {

    @Autowired
    public EmployeeMapper employeeMapper;

    public Collection<Employee> getAll() {
        return employeeMapper.getAll();
    }

    public void save(Employee employee) {
        employeeMapper.save(employee);
    }

    public Employee getEmpById(Integer empId) {
        return employeeMapper.getEmpById(empId);
    }

    public void delete(Integer empId) {
        employeeMapper.delete(empId);
    }

    public void update(Employee employee){
        employeeMapper.update(employee);
    }
}
