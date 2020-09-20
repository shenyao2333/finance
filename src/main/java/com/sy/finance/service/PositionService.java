package com.sy.finance.service;

import com.sy.finance.domain.Position;

import java.util.List;

public interface PositionService{


    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    List<Position> selectByAll(Position position);
}
