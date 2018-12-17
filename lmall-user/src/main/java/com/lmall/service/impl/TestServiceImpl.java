package com.lmall.service.impl;

import com.lmall.service.TestService;
import org.springframework.stereotype.Service;

/**
 * Created by reckywangbowen_i on 2018/12/05
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public String test() {
        return "test";
    }
}
