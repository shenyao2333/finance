package com.sy.finance.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author sy
 * @date Created in 2020.7.14 21:21
 * @description 用户登陆
 */
@Data
@ApiModel
public class UserLogDto implements Serializable {


    @ApiModelProperty(value = "用户账号（手机号或者用户名）", required = true)
    @NotBlank(message = "账号不能为空")
    private String accounts;

    @ApiModelProperty(value = "密码", required = true)
    @NotBlank(message = "密码不能为空")
    private String password;


}
