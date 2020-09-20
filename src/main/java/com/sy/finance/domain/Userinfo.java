package com.sy.finance.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value = "Userinfo")
@Data
public class Userinfo implements Serializable {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
     * 使用名
     */
    @ApiModelProperty(value = "使用名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

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

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm" ,timezone = "GMT+8")
    private Date created;

    private static final long serialVersionUID = 1L;
}
