package com.sy.finance.mapper;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Date;

import com.sy.finance.domain.Income;

public interface IncomeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Income record);

    int insertSelective(Income record);

    Income selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Income record);

    int updateByPrimaryKey(Income record);


    List<Income> selectByAll(Income income);


    int updateStatusById(@Param("id") Integer id, @Param("status") Integer status);

    int updateClearingById(@Param("updatedClearing")Integer updatedClearing,@Param("id")Integer id);

}
