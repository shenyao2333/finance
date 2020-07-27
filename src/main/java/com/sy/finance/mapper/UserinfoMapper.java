package com.sy.finance.mapper;

import com.sy.finance.domain.Userinfo;
import com.sy.finance.domain.dto.UserLogDto;

public interface UserinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);

    Userinfo login(UserLogDto logDto);
}
