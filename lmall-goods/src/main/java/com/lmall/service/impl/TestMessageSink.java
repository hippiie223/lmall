package com.lmall.service.impl;

import com.lmall.stream.Sink;
import com.lmall.stream.message.TestMessage;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;

/**
 * Created by reckywangbowen_i on 2018/12/13
 */
@EnableBinding(Sink.class)
public class TestMessageSink {

    @StreamListener(Sink.TEST_INPUT)
    public void testInput(TestMessage message){
/*        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT,Acknowledgment.class);
        if(acknowledgment == null){
            System.out.println("kafka error");
        }*/
        System.out.println("Recevied:" + message.toString());
    }
}
