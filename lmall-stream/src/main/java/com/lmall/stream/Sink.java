package com.lmall.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by reckywangbowen_i on 2018/12/13
 */
public interface Sink {
    String TEST_INPUT = "test_input";

    @Input(Sink.TEST_INPUT)
    SubscribableChannel testInput();
}
