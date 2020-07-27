package com.sy.finance.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

import javax.validation.constraints.NotNull;

@ApiModel(value="com-sy-finance-domain-IncomeDetail")
@Data
public class IncomeDetail implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 商品名
    */
    @ApiModelProperty(value="商品名")
    private String goodsName;

    /**
    * 数量
    */
    @ApiModelProperty(value="数量")
    private Integer count;

    /**
    * 单价
    */
    @ApiModelProperty(value="单价")
    private BigDecimal price;

    /**
    * 实际金额
    */
    @ApiModelProperty(value="实际金额")
    private BigDecimal actualPrice;

    /**
    * 单数总价
    */
    @ApiModelProperty(value="单数总价")
    private BigDecimal prices;

    /**
    * 状态 0-未结清  1-结清
    */
    @ApiModelProperty(value="状态 0-未结清  1-结清")
    private Integer clearing;

    /**
    * 父id
    */
    @ApiModelProperty(value="父id")
    private Integer parentId;


    @NotNull(message ="page不能为空" )
    @ApiModelProperty(value = "页码",required = true)
    private Integer page;

    @NotNull(message ="pageSize不能为空" )
    @ApiModelProperty(value = "数据量",required = true)
    private Integer pageSize;

    private static final long serialVersionUID = 1L;
}
