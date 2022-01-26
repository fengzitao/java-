package com.itheima.web.ajax;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.User;

/**
 * @author fengzitao
 * @date 2022/01/25
 */
public class FastJsonDemo {

    public static void main(String[] args) {
        //1. 将Java对象转为JSON字符串
        User user1 = new User();
        user1.setId(100);
        user1.setName("zhangsan");
        user1.setAge(20);
        String jsonString = JSON.toJSONString(user1);
        System.out.println(jsonString);


        //2. 将JSON字符串转为Java对象
        User user2 = JSON.parseObject(jsonString, User.class);
        System.out.println(user2);
    }
}
