package com.lmall.service.impl;

import com.lmall.domain.Users;
import com.lmall.domain.example.UsersExample;
import com.lmall.mapper.UsersMapper;
import com.lmall.service.UserService;
import com.lmall.util.CheckSumBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by reckywangbowen_i on 2019/03/04
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void insertUser(Users users) {
        usersMapper.insertSelective(users);
    }

    @Override
    public boolean login(String phone, String password) {
        Users users = usersMapper.selectByPrimaryKey(phone);
        return CheckSumBuilder.getMD5(password).equals(users.getPassword());
    }
}
