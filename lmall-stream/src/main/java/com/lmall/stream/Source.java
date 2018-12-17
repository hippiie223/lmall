package com.lmall.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by reckywangbowen_i on 2018/12/13
 */
public interface Source {
    String TEST_OUTPUT = "test_output";

    @Output(Source.TEST_OUTPUT)
    MessageChannel testOutput();
}
