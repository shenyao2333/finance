package com.sy.finance.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value="com-sy-finance-domain-Template")
@Data
public class Template implements Serializable {
    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private Integer id;

    /**
    * 模版类型
    */
    @ApiModelProperty(value="模版类型")
    private String fileType;

    /**
    * 备注
    */
    @ApiModelProperty(value="备注")
    private String remark;

    /**
    * 模版名
    */
    @ApiModelProperty(value="模版名")
    private String fileName;

    /**
    * 说明
    */
    @ApiModelProperty(value="url")
    private String fileUrl;

    private static final long serialVersionUID = 1L;
}
