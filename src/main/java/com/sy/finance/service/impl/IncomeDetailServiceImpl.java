package com.sy.finance.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sy.finance.domain.IncomeDetail;
import com.sy.finance.mapper.IncomeDetailMapper;
import com.sy.finance.service.IncomeDetailService;

import java.util.List;

@Service
public class IncomeDetailServiceImpl implements IncomeDetailService{

    @Resource
    private IncomeDetailMapper incomeDetailMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return incomeDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(IncomeDetail record) {
        return incomeDetailMapper.insert(record);
    }

    @Override
    public int insertSelective(IncomeDetail record) {
        return incomeDetailMapper.insertSelective(record);
    }

    @Override
    public IncomeDetail selectByPrimaryKey(Integer id) {
        return incomeDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(IncomeDetail record) {
        return incomeDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(IncomeDetail record) {
        return incomeDetailMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<IncomeDetail> selectByAll(IncomeDetail incomeDetail) {
        return incomeDetailMapper.selectByAll(incomeDetail);
    }

}
