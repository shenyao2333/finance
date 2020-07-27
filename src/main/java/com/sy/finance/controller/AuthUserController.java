package com.sy.finance.controller;

import com.sy.finance.domain.Income;
import com.sy.finance.domain.Userinfo;
import com.sy.finance.domain.dto.UserLogDto;
import com.sy.finance.domain.vo.LoginUserinfo;
import com.sy.finance.service.IncomeService;
import com.sy.finance.service.UserinfoService;
import com.sy.finance.web.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author sy
 * @date Created in 2020.7.14 21:19
 * @description 用户登陆
 */
@RestController
@RequestMapping("/userAuth")
@Api(tags = "用户登录")
public class AuthUserController  {


    @Resource
    private UserinfoService userinfoService;




    @PostMapping("/login")
    @ApiOperation(value = "用户登陆",notes = "使用手机号或者用户名登陆")
    public RespBean<LoginUserinfo> login(@RequestBody @Valid UserLogDto logDto){
        LoginUserinfo userinfo =  userinfoService.login(logDto);
        return RespBean.succeed(userinfo);
    }

















}
