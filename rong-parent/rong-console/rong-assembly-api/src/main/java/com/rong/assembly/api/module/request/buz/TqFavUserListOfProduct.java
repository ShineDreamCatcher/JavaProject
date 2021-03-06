package com.rong.assembly.api.module.request.buz;

import com.rong.common.annotation.RequireValidator;
import com.rong.common.module.TqPageListBase;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TqFavUserListOfProduct extends TqPageListBase {
    @ApiModelProperty(value = "产品id",required = true)
    @RequireValidator
    private Long securityId;
}
