package com.njcit.springboot_demo.mapper;

import com.njcit.springboot_demo.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @Author: LiJun
 * @Date: 2020/8/2 4:30 下午
 */

@Mapper
@Repository
public interface EmployeeMapper {

    Collection<Employee> getAll();

    void save(Employee employee);

    Employee getEmpById(Integer empId);

    void delete(Integer empId);

    void update(Employee employee);

}
