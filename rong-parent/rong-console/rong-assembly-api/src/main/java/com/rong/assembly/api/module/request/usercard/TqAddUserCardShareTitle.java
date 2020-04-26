package com.rong.assembly.api.module.request.usercard;

import com.rong.common.annotation.RequireValidator;
import com.rong.common.module.TqUserAuthBase;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TqAddUserCardShareTitle extends TqUserAuthBase {
    @ApiModelProperty(value = "分享标题内容",required = true)
    @RequireValidator
    private String title;
}
