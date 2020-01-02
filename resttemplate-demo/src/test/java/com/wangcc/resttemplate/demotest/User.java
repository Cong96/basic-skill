package com.wangcc.resttemplate.demotest;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: BryantCong
 * @Date: 2019/12/19 10:28
 * @Description:
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -6372749197695616205L;
    private String name;

    private Integer age;
}

