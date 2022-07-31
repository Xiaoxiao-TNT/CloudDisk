package com.csj.account.dao;


import com.csj.account.entity.po.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminDao {

    @Select("select * from admin where adminId=#{adminId} and password=#{password}")
    Admin login(Admin admin);

}
