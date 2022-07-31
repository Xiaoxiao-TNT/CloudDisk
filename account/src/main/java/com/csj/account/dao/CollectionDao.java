package com.csj.account.dao;


import com.csj.account.entity.po.Collection;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CollectionDao {

    @Insert("insert into collection(userId,filename,filepath,isDir) values(#{userId},#{filename},#{filepath},#{isDir})")
    int favor(int userId, String filename, String filepath, boolean isDir);

    @Delete("delete from collection where userId=#{userId} and filepath=#{filepath}")
    int unfavor(int userId, String filepath);

    @Select("select* from collection where userId=#{userId} and filepath=#{filepath}")
    Collection isExist(int userId, String filepath);

    @Select("select* from collection where userId=#{userId}")
    List<Collection> selectByUserId(int userId);

    @Delete("delete from collection where userId=#{userId}")
    int deleteById(int userId);
}
