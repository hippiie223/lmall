package com.lmall.controller;

import com.lmall.respbody.RootRespBody;
import com.lmall.service.TestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by reckywangbowen_i on 2018/12/05
 */
@RestController
public class TestController {

    @Autowired
    private TestClient testClient;

    @RequestMapping(path = "/test")
    public RootRespBody<String> test(){
        String data = testClient.test();
        return RootRespBody.success(data);
    }

    @RequestMapping(path = "/wbw/test")
    public String wbwTest(){
        return "wbw test";
    }


}
