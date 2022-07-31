package com.csj.account.service;

import com.csj.account.entity.po.Message;
import com.csj.account.entity.po.User;

import java.util.List;

public interface UserService {
    User login(User user);
    User selectById(int userId);
    int insert(User user);
    String getNameById(int userId);
    int deleteById(int userId);
    int update(User user);
    List<User> findAll();
    User findUserByUserName(String username);
    List<Message> getMsgs(int id);
    int sendEmail(int from ,int to,String title,String content);
    int readEmail(int msgId);
    int deleEmail(int msgId);
    int getIdByName(String username);

}
