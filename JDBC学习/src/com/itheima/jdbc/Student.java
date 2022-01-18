package com.itheima.jdbc;

import lombok.Data;

import java.sql.Date;

/**
 * @author fengzitao
 * @date 2022/01/18
 */
@Data
public class Student {
    private int sid ;
    private String name;
    private String gender ;
    private int age;
    private Date birth ;
    private String address ;

}
