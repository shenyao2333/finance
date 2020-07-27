package com.sy.finance.service;

import com.sy.finance.domain.IncomeDetail;

import java.util.List;

public interface IncomeDetailService{


    int deleteByPrimaryKey(Integer id);

    int insert(IncomeDetail record);

    int insertSelective(IncomeDetail record);

    IncomeDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IncomeDetail record);

    int updateByPrimaryKey(IncomeDetail record);

    List<IncomeDetail> selectByAll(IncomeDetail incomeDetail);

}
