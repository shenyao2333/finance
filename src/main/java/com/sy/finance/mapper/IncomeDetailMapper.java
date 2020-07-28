package com.sy.finance.mapper;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.sy.finance.domain.IncomeDetail;

public interface IncomeDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IncomeDetail record);

    int insertSelective(IncomeDetail record);

    IncomeDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IncomeDetail record);

    int updateByPrimaryKey(IncomeDetail record);

    List<IncomeDetail> selectByAll(IncomeDetail incomeDetail);


    List<IncomeDetail> selectByParentId(@Param("parentId")Integer parentId);




}
