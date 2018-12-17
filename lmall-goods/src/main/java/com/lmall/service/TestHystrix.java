package com.lmall.service;

import org.springframework.stereotype.Component;

/**
 * Created by reckywangbowen_i on 2018/12/10
 */
@Component
public class TestHystrix implements TestClient {
    @Override
    public String test() {
        return "sorry";
    }
}
