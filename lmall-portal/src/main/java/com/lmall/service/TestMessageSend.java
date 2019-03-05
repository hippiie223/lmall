package com.lmall.service;

import com.lmall.stream.Source;
import com.lmall.stream.message.TestMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

/**
 * Created by reckywangbowen_i on 2018/12/13
 */
@EnableBinding(Source.class)
public class TestMessageSend {
    @Autowired
    private Source source;

    public void sendMessage(TestMessage message){
        try {
            source.testOutput().send(MessageBuilder.withPayload(message).build());
        }catch (Exception e ){
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}
