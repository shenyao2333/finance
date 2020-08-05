package com.sy.finance.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sy.finance.domain.Income;
import com.sy.finance.domain.IncomeDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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

    @ApiModelProperty(value="主键id")
    private Integer id;

    /**
     * 客户姓名
     */
    @ApiModelProperty(value="客户姓名")
    private String clientName;

    /**
     * 公司
     */
    @ApiModelProperty(value="公司")
    private String company;

    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号")
    private String phone;

    /**
     * 总金额
     */
    @ApiModelProperty(value="总金额")
    private BigDecimal totalMoney;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date created;

    /**
     * 流水号
     */
    @ApiModelProperty(value="流水号")
    private String serialUmber;

    /**
     * 订单状态  默认为1，1-正常 ，0-删除
     */
    @ApiModelProperty(value="订单状态  默认为1，1-正常 ，0-删除")
    private Integer status=1;

    /**
     * 结算状态，状态 0-未结清  1-结清
     */
    @ApiModelProperty(value="结算状态，默认为0，状态 0-未结清  1-结清")
    private Integer clearing=0;



    @ApiModelProperty(value="操作人")
    private String operator;



    @ApiModelProperty(value = "收入详情")
    private List<IncomeDetail> incomeDetailList;

}
