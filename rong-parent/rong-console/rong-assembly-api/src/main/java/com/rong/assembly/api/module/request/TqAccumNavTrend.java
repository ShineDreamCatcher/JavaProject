package com.rong.assembly.api.module.request;

import com.rong.common.module.TqBase;
import com.rong.common.util.DateUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Description TODO
 * @Author ludexin
 * @Date 2020-01-16 15:14
 **/
@Data
public class TqAccumNavTrend extends TqBase {

    @ApiModelProperty(value = "证券内部编码", name = "securityId", required = true)
    private Integer securityId;

    @DateTimeFormat(pattern = DateUtil.yyyy_MM_dd_EN)
    @ApiModelProperty(value = "开始时间", name = "startDate")
    private Date startDate;

    @DateTimeFormat(pattern = DateUtil.yyyy_MM_dd_EN)
    @ApiModelProperty(value = "结束时间", name = "endDate")
    private Date endDate;


}
