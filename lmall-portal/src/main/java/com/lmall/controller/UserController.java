package com.lmall.controller;

import com.lmall.domain.UserInfo;
import com.lmall.domain.Users;
import com.lmall.domain.example.UsersExample;
import com.lmall.message.SendCode;
import com.lmall.request.InsertUserRequestBody;
import com.lmall.request.LoginRequestBody;
import com.lmall.request.UpdateUserInfoRequestBody;
import com.lmall.respbody.RootRespBody;
import com.lmall.response.UserInfoRespBody;
import com.lmall.service.UserService;
import com.lmall.util.CheckSumBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by reckywangbowen_i on 2019/03/04
 */
@Api("用户相关接口")
@RestController
@RequestMapping(path = "/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping(path = "/code")
    @ApiOperation("获取验证码")
    public RootRespBody getCode(@RequestParam String phone){

        try {
            String response = SendCode.send(phone);
            return RootRespBody.success(response);
        } catch (Exception e) {
            logger.error("发送验证码错误!");
        }
        return RootRespBody.success();
    }

    @PostMapping(path = "/insert")
    @ApiOperation("新建用户")
    public RootRespBody insert(@RequestBody InsertUserRequestBody insertUserRequestBody){
        if(!insertUserRequestBody.getCode().equals(insertUserRequestBody.getInputCode())){
            return RootRespBody.failure(RootRespBody.Status.REQUEST_PARAMETER_ERROR, "验证码输入错误!");
        }

        if("".equals(insertUserRequestBody.getPhone()) || insertUserRequestBody.getPhone() == null){
            return RootRespBody.failure(RootRespBody.Status.REQUEST_PARAMETER_ERROR, "手机号不能为空！");
        }

        if("".equals(insertUserRequestBody.getPassword()) || insertUserRequestBody.getPassword() == null){
            return RootRespBody.failure(RootRespBody.Status.REQUEST_PARAMETER_ERROR, "密码不能为空！");
        }


        UserInfo users = new UserInfo();
        String password = CheckSumBuilder.getMD5(insertUserRequestBody.getPassword());
        users.setPhone(insertUserRequestBody.getPhone());
        if(insertUserRequestBody.getUsername() != null){
            users.setUserName(insertUserRequestBody.getUsername());
        }
        users.setPassword(password);
        try {
            userService.insertUser(users);
        }catch (Exception e){
            return RootRespBody.failure(RootRespBody.Status.INSERT_RECORD_ERROR,"手机号已注册");
        }
        return RootRespBody.success();
    }

    @PostMapping(path = "/login")
    @ApiOperation("用户登录")
    public RootRespBody login(@RequestBody LoginRequestBody loginRequestBody){
        if(userService.login(loginRequestBody.getUsername(), loginRequestBody.getPassword())){
            return RootRespBody.success();
        }
        return RootRespBody.failure(RootRespBody.Status.REQUEST_PARAMETER_ERROR,"密码错误！");
    }

    @GetMapping(path = "/is/username/exist")
    @ApiOperation("用户名是否存在")
    public RootRespBody isUserNameExist(@RequestParam String userName){
        if(userService.isNameExist(userName)){
            return RootRespBody.success(true);
        }else {
            return RootRespBody.success(false);
        }
    }

    @PostMapping(path = "/focus")
    @ApiOperation("关注用户")
    public RootRespBody focus(@RequestParam String userName, @RequestParam String focusUserName){
        if(userService.userFocus(userName, focusUserName)){
            return RootRespBody.success("关注成功!");
        }else {
            return RootRespBody.success("关注失败!");
        }
    }

    @GetMapping(path = "/get/user/info")
    @ApiOperation("获取用户个人信息")
    public RootRespBody<UserInfoRespBody> getUserInfo(@RequestParam String userName){
        return RootRespBody.success(userService.getUserInfo(userName));
    }

    @PostMapping(path = "edit/user/info")
    @ApiOperation("编辑用户信息")
    public RootRespBody editUserInfo(@RequestBody UpdateUserInfoRequestBody requestBody){
        userService.updateUserInfo(requestBody);
        return RootRespBody.success();
    }

    @GetMapping(path = "/list/focus")
    @ApiOperation("获取关注列表")
    public RootRespBody<List<String>> getFocusList(@RequestParam String userName, @RequestParam int pageNum, @RequestParam int pageSize){
        return RootRespBody.success(userService.getFocusList(userName, pageNum, pageSize));
    }

    @GetMapping(path = "/list/fans")
    @ApiOperation("获取粉丝列表")
    public RootRespBody<List<String>> getFansList(@RequestParam String userName, @RequestParam int pageNum, @RequestParam int pageSize){
        return RootRespBody.success(userService.getFansList(userName, pageNum, pageSize));
    }

    @PostMapping(path = "/delete/focus")
    @ApiOperation("取消关注")
    public RootRespBody deleteFocus(@RequestParam String userName, @RequestParam String focusUserName){
        return RootRespBody.success(userService.deleteFocus(userName, focusUserName));
    }

    @PostMapping(path = "/delete/fans")
    @ApiOperation("移除粉丝")
    public RootRespBody deleteFans(@RequestParam String userName, @RequestParam String fansUserName){
        return RootRespBody.success(userService.deleteFans(userName, fansUserName));
    }



}
