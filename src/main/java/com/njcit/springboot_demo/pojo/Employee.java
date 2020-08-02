package com.njcit.springboot_demo.pojo;

import com.alibaba.druid.sql.visitor.functions.Char;
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
    private String gender;
    private Integer dId;
    private Department department;
    private Date birth;

}
