package com.lmall.service.impl;

import com.lmall.domain.FocusAndFans;
import com.lmall.domain.UserInfo;
import com.lmall.domain.Users;
import com.lmall.domain.example.FocusAndFansExample;
import com.lmall.domain.example.UserInfoExample;
import com.lmall.domain.example.UsersExample;
import com.lmall.mapper.FocusAndFansMapper;
import com.lmall.mapper.UserInfoMapper;
import com.lmall.mapper.UsersMapper;
import com.lmall.request.UpdateUserInfoRequestBody;
import com.lmall.response.UserInfoRespBody;
import com.lmall.service.UserService;
import com.lmall.util.CheckSumBuilder;
import com.lmall.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by reckywangbowen_i on 2019/03/04
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private FocusAndFansMapper focusAndFansMapper;

    @Override
    public void insertUser(UserInfo users) {
        users.setCreateTime(TimeUtil.getCurrentTime());
        userInfoMapper.insertSelective(users);
    }

    @Override
    public boolean login(String phone, String password) {
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andPhoneEqualTo(phone);
        UserInfo users = userInfoMapper.selectByExample(userInfoExample).get(0);
        return CheckSumBuilder.getMD5(password).equals(users.getPassword());
    }

    @Override
    public boolean userFocus(String userName, String focusUserName) {
        FocusAndFans focusAndFans = new FocusAndFans();
        focusAndFans.setFocus(focusUserName);
        focusAndFans.setFans(userName);
        if(focusAndFansMapper.insertSelective(focusAndFans) != 1){
            return false;
        }
        return true;
    }

    @Override
    public boolean isNameExist(String name) {
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andUserNameEqualTo(name);
        if(userInfoMapper.countByExample(userInfoExample) != 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePassword(String userName, String oldPassword, String newPassword) {
        return false;
    }

    @Override
    public void updateUserInfo(UpdateUserInfoRequestBody requestBody) {
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andUserNameEqualTo(requestBody.getOldUserName());

        UserInfo userInfo = new UserInfo();
        if(requestBody.getUserName() != null){
            userInfo.setUserName(requestBody.getUserName());
            FocusAndFansExample focusAndFansExample = new FocusAndFansExample();
            focusAndFansExample.createCriteria().andFocusEqualTo(requestBody.getOldUserName());
            FocusAndFans focusAndFans = new FocusAndFans();
            focusAndFans.setFocus(requestBody.getUserName());
            focusAndFansMapper.updateByExampleSelective(focusAndFans, focusAndFansExample);

            focusAndFansExample.clear();
            focusAndFansExample.createCriteria().andFansEqualTo(requestBody.getOldUserName());
            focusAndFans.setFocus("");
            focusAndFans.setFans(requestBody.getUserName());
            focusAndFansMapper.updateByExampleSelective(focusAndFans, focusAndFansExample);
        }
        if(requestBody.getAddress() != null){
            userInfo.setAddress(requestBody.getAddress());
        }
        if(requestBody.getEmail() != null){
            userInfo.setEmail(requestBody.getEmail());
        }
        if(requestBody.getGender() != null){
            userInfo.setGender(requestBody.getGender());
        }
        if(requestBody.getJob() != null){
            userInfo.setJob(requestBody.getJob());
        }
        if(requestBody.getSchool() != null){
            userInfo.setSchool(requestBody.getSchool());
        }
        if(requestBody.getSignature() != null){
            userInfo.setSignature(requestBody.getSignature());
        }

        userInfoMapper.updateByExampleSelective(userInfo, userInfoExample);
    }

    @Override
    public UserInfoRespBody getUserInfo(String userName) {
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andUserNameEqualTo(userName);
        UserInfo userInfo = userInfoMapper.selectByExample(userInfoExample).get(0);

        FocusAndFansExample focusAndFansExample = new FocusAndFansExample();
        focusAndFansExample.createCriteria().andFansEqualTo(userName);
        int focusNum = focusAndFansMapper.countByExample(focusAndFansExample);
        focusAndFansExample.clear();
        focusAndFansExample.createCriteria().andFocusEqualTo(userName);
        int fansNum = focusAndFansMapper.countByExample(focusAndFansExample);



        UserInfoRespBody userInfoRespBody = new UserInfoRespBody();
        userInfoRespBody.setUserName(userInfo.getUserName());
        userInfoRespBody.setPhone(userInfo.getPhone());
        userInfoRespBody.setAddress(userInfo.getAddress());
        userInfoRespBody.setEmail(userInfo.getEmail());
        userInfoRespBody.setGender(userInfo.getGender());
        userInfoRespBody.setJob(userInfo.getJob());
        userInfoRespBody.setSchool(userInfo.getSchool());
        userInfoRespBody.setSignature(userInfo.getSignature());
        userInfoRespBody.setFocusNum(focusNum);
        userInfoRespBody.setFansNum(fansNum);

        return userInfoRespBody;
    }
}
