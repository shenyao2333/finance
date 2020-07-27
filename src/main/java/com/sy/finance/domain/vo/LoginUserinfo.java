package com.sy.finance.domain.vo;

import com.sy.finance.domain.Userinfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author sy
 * @date Created in 2020.7.27 21:52
 * @description
 */
@Data
@ApiModel
public class LoginUserinfo implements Serializable {


    private static final long serialVersionUID = -599989741998559071L;

    @ApiModelProperty(value = "用户信息")
    private Userinfo userinfo;

    @ApiModelProperty(value = "用户凭证")
    private String token;

    @ApiModelProperty(value = "有效时间，单位秒")
    private Long validTime;

}
