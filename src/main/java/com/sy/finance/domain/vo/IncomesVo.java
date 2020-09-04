package com.sy.finance.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.pagehelper.PageInfo;
import com.sy.finance.domain.Income;
import com.sy.finance.domain.IncomeDetail;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author sy
 * @date Created in 2020.9.4 20:36
 * @description
 */
@Data
public class IncomesVo {


    private Income income;



    private PageInfo<IncomesVo> list;


    private static final long serialVersionUID = 1L;
}
