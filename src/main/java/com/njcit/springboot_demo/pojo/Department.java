package com.njcit.springboot_demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LiJun
 * @Date: 2020/7/30 10:09 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer departId;
    private String departmentName;
}
