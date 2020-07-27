package com.sy.finance.domain.dto;

import com.sy.finance.domain.Income;
import com.sy.finance.domain.IncomeDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author sy
 * @date Created in 2020.7.27 21:58
 * @description 添加收入信息对象
 */
@Data
@ApiModel
public class AddIncomeInfoDto implements Serializable {


    private static final long serialVersionUID = 25706244054011812L;

    @ApiModelProperty(value = "收入")
    private Income income;

    @ApiModelProperty(value = "收入详情")
    private List<IncomeDetail> incomeDetailList;

}
