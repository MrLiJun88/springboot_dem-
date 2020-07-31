package com.njcit.springboot_demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: LiJun
 * @Date: 2020/7/30 10:13 下午
 */

@Data
@NoArgsConstructor
public class Employee {

    private Integer empId;
    private String lastName;
    private String email;
    /** 0：男，1：女*/
    private Integer gender;
    private Department department;
    private Date birth;

    public Employee(Integer empId, String lastName, String email, Integer gender, Department department) {
        this.empId = empId;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = new Date();
    }
}
