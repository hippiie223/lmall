package com.lmall.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "lmall-user",fallback = TestHystrix.class)
public interface TestClient extends TestApiService {
}
