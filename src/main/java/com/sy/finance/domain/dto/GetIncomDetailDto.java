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
     * 父id
     */
    @ApiModelProperty(value="父id")
    private Integer parentId;

    /**
     * 商品名
     */
    @ApiModelProperty(value="商品名")
    private String goodsName;



    @NotNull(message = "页码不能为空")
    @ApiModelProperty(value = "页码")
    private Integer page;

    @NotNull(message = "数据量不能为空")
    @ApiModelProperty(value = "数据量")
    private Integer pageSize;

}
