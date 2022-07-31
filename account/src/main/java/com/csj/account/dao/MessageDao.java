package com.csj.account.dao;


import com.csj.account.entity.po.Message;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageDao {
    @Select(("select * from message where receive=#{receiveId}"))
    List<Message> getByReceiveId(int receiveId);

    @Insert("insert into message(send,receive,title,content,sendtime,status) values(#{send},#{receive},#{title},#{content},#{sendtime},#{status})")
    int insert(Message msg);

    @Update("update message set send=#{send},receive=#{receive},title=#{title},content=#{content},sendtime=#{sendtime},status=#{status} where id=#{id}")
    int update(Message msg);

    @Select("select * from message where id=#{msgId}")
    Message getById(int msgId);

    @Delete("delete from message where id=#{msgId}")
    int delete(int msgId);
}
