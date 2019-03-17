package com.lmall.service;

import com.lmall.domain.Users;
import org.springframework.stereotype.Service;

/**
 * Created by reckywangbowen_i on 2019/03/04
 */
@Service
public interface UserService {
    void insertUser(Users users);
    boolean login(String phone, String password);
}
