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
    @ApiModelProperty(value="" ,required = true)
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
    private BigDecimal price = new BigDecimal("0") ;

    /**
    * 实际金额
    */
    @ApiModelProperty(value="实际金额")
    private BigDecimal actualPrice=new BigDecimal("0") ;

    /**
    * 单数总价
    */
    @ApiModelProperty(value="单项总价")
    private BigDecimal prices=new BigDecimal("0") ;

    /**
    * 状态 0-未结清  1-结清
    */
    @ApiModelProperty(value="状态 0-未结清  1-结清，默认为0")
    private Integer clearing=0;

    /**
    * 父id
    */
    @ApiModelProperty(value="父id")
    private Integer parentId;




    private static final long serialVersionUID = 1L;
}
