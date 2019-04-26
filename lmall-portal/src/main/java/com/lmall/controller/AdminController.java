package com.lmall.controller;

import com.lmall.domain.QiNiu;
import com.lmall.service.AdminService;
import io.swagger.annotations.Api;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 39239
 * @Date 2019/4/26 10:58
 * @Package com.lmall.controller
 * @Description:
 */
@Api("管理员相关接口")
@RestController
@RequestMapping(path = "/admin")
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @GetMapping(path = "/token")
    public QiNiu getToken(){
        return adminService.getToken();
    }
}
