package com.sy.finance.service;

import com.sy.finance.domain.Userinfo;
import com.sy.finance.domain.dto.UpdPassword;
import com.sy.finance.domain.dto.UserLogDto;
import com.sy.finance.domain.vo.LoginUserinfo;

import javax.servlet.http.HttpServletRequest;

public interface UserinfoService {


    int deleteByPrimaryKey(Integer id);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);

    /**
     * 用户登陆
     * @param logDto
     * @return
     */
    LoginUserinfo login(UserLogDto logDto);

    /**
     * 注销登陆
     */
    void logout(HttpServletRequest request);

    void updPassword(UpdPassword updPassword);
}

