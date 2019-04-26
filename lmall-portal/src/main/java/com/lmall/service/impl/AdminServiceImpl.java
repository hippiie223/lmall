package com.lmall.service.impl;

import com.lmall.domain.QiNiu;
import com.lmall.service.AdminService;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author 39239
 * @Date 2019/4/26 10:47
 * @Package com.lmall.service.impl
 * @Description:
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Override
    public QiNiu getToken() {
        QiNiu qiNiu = new QiNiu();
        String accessKey = "8sZJJeuAxFfbWIEy7C_33ixMc2FC_a5b4mwK4Tzk";
        String secretKey = "Q1yZalN49vBZsa_8l7UDiB0BI8IsrKIImNDWVvTx";
        String bucket = "houzhidao";
        long expireSeconds = 600;   //过期时间
        StringMap putPolicy = new StringMap();
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket,null, expireSeconds,putPolicy);
        qiNiu.setKey(UUID.randomUUID().toString().replaceAll("\\-", ""));
        qiNiu.setToken(upToken);
        return qiNiu;
    }
}
