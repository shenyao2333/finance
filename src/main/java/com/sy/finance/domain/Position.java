package com.sy.finance.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-sy-finance-domain-Position")
@Data
public class Position implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 使用名
    */
    @ApiModelProperty(value="使用名")
    private String userName;

    /**
    * 职位
    */
    @ApiModelProperty(value="职位")
    private String position;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date created;

    @ApiModelProperty(value="更新时间")
    private Date updated;

    /**
    * 性别0-女，1-男
    */
    @ApiModelProperty(value="性别0-女，1-男")
    private String sex;

    /**
    * 顺序
    */
    @ApiModelProperty(value="顺序")
    private Integer sequence;

    private Integer addUserId;


    private static final long serialVersionUID = 1L;
}
