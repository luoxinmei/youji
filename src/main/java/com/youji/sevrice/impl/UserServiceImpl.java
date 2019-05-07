package com.youji.sevrice.impl;

import com.youji.dao.IUserDao;
import com.youji.pojo.User;
import com.youji.req.UserCheckReq;
import com.youji.req.UserLoginReq;
import com.youji.req.UserRegisterReq;
import com.youji.req.UserUpdatePwdReq;
import com.youji.sevrice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao userDao;

    @Override
    public Boolean checkUserName(UserCheckReq req) {
        List<User> users = userDao.checkUserName(req.getUsername());
        return users.size() == 1 ? true : false;
    }

    @Override
    public Boolean register(UserRegisterReq req) {
        int i = userDao.insert(req.getUsername(),req.getPassword());
        return i == 1 ? true : false;
    }

    @Override
    public User login(UserLoginReq req) {
        List<User> users = userDao.findUser(req.getUsername(),req.getPassword());
        return users.size() == 1 ? users.get(0) : null;
    }

    @Override
    public Boolean updatePassword(UserUpdatePwdReq req) {
        int i = userDao.updateByPrimaryKeySelective(req.getUserId(),req.getPassword());
        return i==1?true:false;
    }


}
