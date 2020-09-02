package com.sy.finance.service.impl;

import com.sy.finance.domain.dto.UpdPassword;
import com.sy.finance.domain.dto.UserLogDto;
import com.sy.finance.domain.vo.LoginUserinfo;
import com.sy.finance.redis.RedisUtil;
import com.sy.finance.utils.JwtTokenUtil;
import com.sy.finance.web.GrabException;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.sy.finance.mapper.UserinfoMapper;
import com.sy.finance.domain.Userinfo;
import com.sy.finance.service.UserinfoService;

@Service
public class UserinfoServiceImpl implements UserinfoService {

    @Resource
    private UserinfoMapper userinfoMapper;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userinfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Userinfo record) {
        return userinfoMapper.insert(record);
    }

    @Override
    public int insertSelective(Userinfo record) {
        return userinfoMapper.insertSelective(record);
    }

    @Override
    public Userinfo selectByPrimaryKey(Integer id) {
        return userinfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Userinfo record) {
        return userinfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Userinfo record) {
        return userinfoMapper.updateByPrimaryKey(record);
    }


    @Override
    public LoginUserinfo login(UserLogDto logDto) {
        Userinfo login = userinfoMapper.login(logDto);
        if (login==null){
           throw new GrabException(2001,"用户名或密码错误!");
        }
        LoginUserinfo loginUserinfo = new LoginUserinfo();
        String token = JwtTokenUtil.createToken(login.getUsername());
        redisUtil.set("token::"+token,login,60*60*6);
        loginUserinfo.setUserinfo(login);
        loginUserinfo.setToken(token);
        loginUserinfo.setValidTime(60*60*6L);
        return loginUserinfo;
    }

    @Override
    public void logout(HttpServletRequest request) {
        String token = JwtTokenUtil.resolveToken(request);
        if (token!=null){
            redisUtil.del("token::"+token,token);
        }

    }

    @Override
    public void updPassword(UpdPassword updPassword) {
        Userinfo userinfo = selectByPrimaryKey(updPassword.getId());
        if (!userinfo.getUsername().equals(updPassword.getOldPwd())){
            throw new GrabException(2003,"修改失败，原密码不对！");
        }
        userinfo.setPassword(updPassword.getNewPwd());
        updateByPrimaryKeySelective(userinfo);
    }


}

