package com.sy.finance.controller;

import com.sy.finance.domain.Userinfo;
import com.sy.finance.domain.dto.UpdPassword;
import com.sy.finance.domain.dto.UpdUserInfo;
import com.sy.finance.service.UserinfoService;
import com.sy.finance.web.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

/**
 * @author sy
 * @date Created in 2020.7.31 22:26
 * @description 用户管理
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {



    @Resource
    private UserinfoService userinfoService;

    @GetMapping("/login")
    @ApiOperation(value = "注销登陆")
    public RespBean logout(HttpServletRequest request){
        userinfoService.logout(request);
        return RespBean.succeed();
    }


    @PostMapping("/updUserInfoById")
    @ApiOperation(value = "修改用户信息")
    public RespBean updUserInfo(@RequestBody @Valid UpdUserInfo userinfo){
        Userinfo userinfo1 = new Userinfo();
        BeanUtils.copyProperties(userinfo,userinfo1);
        userinfoService.updateByPrimaryKeySelective(userinfo1);
        return RespBean.succeed();
    }


    @PostMapping("/updPassword")
    @ApiOperation(value = "修改登录密码")
    public RespBean updPassword( @RequestBody @Valid UpdPassword updPassword){
        userinfoService.updPassword(updPassword);
        return RespBean.succeed();
    }


    @PostMapping("/addUserInfo")
    @ApiOperation(value = "添加用户信息")
    public RespBean addUserInfo( @RequestBody Userinfo userinfo){
        userinfo.setCreated(new Date());
        userinfoService.insert(userinfo);
        return RespBean.succeed();
    }


}
