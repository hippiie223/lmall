package com.lmall.service;

import com.lmall.domain.UserInfo;
import com.lmall.domain.Users;
import com.lmall.request.UpdateUserInfoRequestBody;
import com.lmall.response.UserInfoRespBody;
import org.springframework.stereotype.Service;

/**
 * Created by reckywangbowen_i on 2019/03/04
 */
@Service
public interface UserService {
    void insertUser(UserInfo users);
    boolean login(String phone, String password);
    boolean updatePassword(String userName, String oldPassword, String newPassword);
    boolean isNameExist(String name);
    boolean userFocus(String userName, String focusUserName);
    UserInfoRespBody getUserInfo(String userName);
    void updateUserInfo(UpdateUserInfoRequestBody requestBody);

}
