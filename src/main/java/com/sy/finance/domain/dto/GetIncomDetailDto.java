package com.sy.finance.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author sy
 * @date Created in 2020.7.28 21:03
 * @description
 */
@Data
@ApiModel
public class GetIncomDetailDto implements Serializable {

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
     * 流水号
     */
    @ApiModelProperty(value="流水号")
    private String serialUmber;

    @NotNull(message = "页码不能为空")
    @ApiModelProperty(value = "页码")
    private Integer page;

    @NotNull(message = "数据量不能为空")
    @ApiModelProperty(value = "数据量")
    private Integer pageSize;

}
