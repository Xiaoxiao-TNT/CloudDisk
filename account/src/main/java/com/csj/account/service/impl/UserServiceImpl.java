package com.csj.account.service.impl;


import com.csj.account.dao.CollectionDao;
import com.csj.account.dao.MessageDao;
import com.csj.account.dao.RecycleBinDao;
import com.csj.account.dao.UserDao;
import com.csj.account.entity.po.Message;
import com.csj.account.entity.po.User;
import com.csj.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CollectionDao collectionDao;
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private RecycleBinDao recycleBinDao;

    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public User selectById(int userId) {
        return userDao.selectById(userId);
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public String getNameById(int userId) {
        return userDao.getNameById(userId);
    }

    @Override
    public int deleteById(int userId) {
        userDao.deleteById(userId);
        collectionDao.deleteById(userId);
        recycleBinDao.deleteById(userId);
        return 1;
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findUserByUserName(String username) {
        return userDao.findUserByUserName(username);
    }

    @Override
    public List<Message> getMsgs(int id) {
        return messageDao.getByReceiveId(id);
    }

    @Override
    public int sendEmail(int from, int to, String title, String content) {
        Message message = new Message();
        message.setSendtime(System.currentTimeMillis());
        message.setSend(from);
        message.setReceive(to);
        message.setTitle(title);
        message.setContent(content);
        return messageDao.insert(message);
    }

    @Override
    public int readEmail(int msgId) {
        Message message =messageDao.getById(msgId);
        //已读
        message.setStatus(2);
        return messageDao.update(message);
    }

    @Override
    public int deleEmail(int msgId) {
        return messageDao.delete(msgId);
    }

    @Override
    public int getIdByName(String username) {
        return userDao.getIdByName(username);
    }


}
