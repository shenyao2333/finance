package com.sy.finance.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author sy
 * @date Created in 2020.7.31 22:32
 * @description
 */
@Data
@ApiModel
public class UpdPassword implements Serializable {

    @NotNull
    @ApiModelProperty(value = "用户id",required = true)
    private Integer id;

    @NotNull
    @ApiModelProperty(value = "老密码",required = true)
    private String oldPwd;

    @NotNull
    @ApiModelProperty(value = "新密码",required = true)
    private String newPwd;

}
