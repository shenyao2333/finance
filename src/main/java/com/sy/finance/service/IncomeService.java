package com.sy.finance.service;

import com.sy.finance.domain.Income;
import com.sy.finance.domain.dto.AddIncomeInfoDto;

import java.util.List;

public interface IncomeService{


    int deleteByPrimaryKey(Integer id);

    int insert(Income record);

    int insertSelective(Income record);

    Income selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Income record);

    int updateByPrimaryKey(Income record);

    List<Income> selectByAll(Income income);

    int addIncome(AddIncomeInfoDto addIncomeInfoDto);


    int updateStatusById(Integer id,  Integer status);
}
