package com.youji.dao;


import com.youji.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserDao {

    List<User> checkUserName(String username);

    int insert(@Param("username") String username,@Param("password") String password);

    List<User> findUser(@Param("username") String username, @Param("password") String password);

    int updateByPrimaryKeySelective(@Param("userId") Integer userId, @Param("password") String password);

}