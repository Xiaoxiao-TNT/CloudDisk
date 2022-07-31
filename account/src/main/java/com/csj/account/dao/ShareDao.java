package com.csj.account.dao;


import com.csj.account.entity.po.Share;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ShareDao {
    int insert(Share share);

    @Select("select * from share where id=#{id} and code = #{code}")
    Share select(int id, String code);
}
