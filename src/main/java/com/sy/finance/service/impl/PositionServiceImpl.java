package com.sy.finance.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sy.finance.mapper.PositionMapper;
import com.sy.finance.domain.Position;
import com.sy.finance.service.PositionService;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService{

    @Resource
    private PositionMapper positionMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return positionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Position record) {
        return positionMapper.insert(record);
    }

    @Override
    public int insertSelective(Position record) {
        return positionMapper.insertSelective(record);
    }

    @Override
    public Position selectByPrimaryKey(Integer id) {
        return positionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Position record) {
        return positionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Position record) {
        return positionMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Position> selectByAll(Position position) {
        return positionMapper.selectByAll(position);
    }

}
