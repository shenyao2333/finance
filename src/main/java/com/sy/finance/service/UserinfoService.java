package com.sy.finance.service;

import com.sy.finance.domain.Userinfo;
import com.sy.finance.domain.dto.UserLogDto;
import com.sy.finance.domain.vo.LoginUserinfo;

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
}

