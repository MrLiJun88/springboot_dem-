package com.njcit.springboot_demo.mapper;

import com.njcit.springboot_demo.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: LiJun
 * @Date: 2020/8/2 4:30 下午
 */

@Mapper
@Repository
public interface DepartmentMapper {

    /**
     * 获取所有部门信息
     * @return
     */
    List<Department> getDepartments();
}
