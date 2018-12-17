package com.lmall.lmallportal.controller.user;

import com.lmall.lmallportal.service.TestMessageSend;
import com.lmall.respbody.RootRespBody;
import com.lmall.stream.message.TestMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by reckywangbowen_i on 2018/12/12
 */
@RestController
public class UserRegisterController {
    @Autowired
    private TestMessageSend messageSend;

    @GetMapping(path = "/user/register/test")
    public String userRegisterTest(){
        return "user register test";
    }

    @PostMapping(path = "/user/test")
    public void testMessageSend(@RequestBody TestMessage message){

        messageSend.sendMessage(message);
    }


}
