package com.lmall.service;

import com.lmall.domain.QiNiu;
import org.springframework.stereotype.Service;

/**
 * @author 39239
 * @Date 2019/4/26 10:46
 * @Package com.lmall.service
 * @Description:
 */
@Service
public interface AdminService {
    public QiNiu getToken();
}
