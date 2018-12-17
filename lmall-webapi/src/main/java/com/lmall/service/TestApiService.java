package com.lmall.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface TestApiService {

    /**
      * @param:
      * @return:
      */
    @PostMapping(path = "/api/test")
    String test();

}
