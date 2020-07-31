package com.sy.finance.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author sy
 * @date Created in 2020.7.31 22:29
 * @description
 */
@Data
@ApiModel
public class UpdUserInfo implements Serializable {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id",required = true)
    @NotNull(message = "修改主键不能为空")
    private Integer id;

    /**
     * 使用名
     */
    @ApiModelProperty(value = "使用名")
    private String username;



    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String photo;

    /**
     * 角色
     */
    @ApiModelProperty(value = "角色")
    private String role;

    /**
     * 公司
     */
    @ApiModelProperty(value = "公司")
    private String company;

    /**
     * 说明
     */
    @ApiModelProperty(value = "说明")
    private String msg;
}
