package com.csj.account.dao;


import com.csj.account.entity.po.Recyclebin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RecycleBinDao {
    @Select("select * from recyclebin where userId=#{userId}")
    List<Recyclebin> selectAll(int userId);

    @Insert("insert into recyclebin(userId,filename,oldpath,deletetime) values(#{userId},#{filename},#{oldpath},#{deletetime})")
    int insert(Recyclebin recyclebin);

    @Delete("delete from recyclebin where filename=#{filename} and userId=#{userId}")
    int delete(String filename, int userId);

    @Update("update recyclebin set validdays=#{validdays} where filename=#{filename} and userId=#{userId}")
    int updateDays(Recyclebin recyclebin);

    @Delete("delete from recyclebin where userId=#{userId}")
    int deleteById(int userId);
}
