package com.csj.account.dao;


import com.csj.account.entity.po.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from user where username=#{username} and password=#{password}")
    User login(User user);

    @Select("select * from user where userId = #{userId}")
    User selectById(int userId);
    //增
    @Insert("insert into user(username,password,email) values(#{username},#{password},#{email})")
    int insert(User user);

    @Select("select userId from user where username=#{username}")
    int getIdByName(String name);

    @Select("select username from user where userId=#{userId}")
    String getNameById(int userId);

    //删
    @Delete("delete from user where userId=#{userId}")
    int deleteById(int userId);

    //改
    @Update("update user set username=#{username},  password=#{password} , email=#{email} , permissions=#{permissions} where userId=#{userId}")
    int update(User user);

    //查  查找所有用户
    @Select("select * from user")
    List<User> findAll();



    //查找用户名是否存在
    @Select("select * from user where username=#{username}")
    User findUserByUserName(String username);

    @Select("select file from collection where userId=#{userId}")
    List<String> selectCollections(int userId);

    /*
    //根据邮箱去查找用户
    @Select("select * from user where email=#{email}")
    User findEmail(String email);

    //查找用户是否存在
    @Select("select * from user where username=#{username}")
    User findUserByUserName(String username);
    */

}