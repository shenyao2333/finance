package com.sy.finance.service;

import com.sy.finance.domain.IncomeDetail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface IncomeDetailService{


    int deleteByPrimaryKey(Integer id);

    int insert(IncomeDetail record);

    int insertSelective(IncomeDetail record);

    IncomeDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IncomeDetail record);

    int updateByPrimaryKey(IncomeDetail record);

    List<IncomeDetail> selectByAll(IncomeDetail incomeDetail);

    List<IncomeDetail> selectByParentId(Integer parentId);

    int insertList(ArrayList<IncomeDetail> incomeDetails);


    BigDecimal sumMoney (Integer parentId);
}
