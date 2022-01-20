package com.itheima.mapper;

import com.itheima.pojo.User;

import java.util.List;

/**
 * @author fengzitao
 * @date 2022/01/19
 */

public interface UserMapper {
    List<User> selectAll();

    User selectById(int id);
}
