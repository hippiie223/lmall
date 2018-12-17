package com.lmall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by reckywangbowen_i on 2018/12/12
 */
@RestController
public class TestController {
    @RequestMapping("/register/test")
    public String test(){
        return "test user";
    }
}
