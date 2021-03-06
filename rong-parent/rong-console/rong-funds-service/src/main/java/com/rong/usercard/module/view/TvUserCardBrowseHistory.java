package com.rong.usercard.module.view;

import com.rong.usercard.module.entity.TbUserCardBrowseHistory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TvUserCardBrowseHistory extends TbUserCardBrowseHistory {
    @ApiModelProperty("对方名片Id")
    private Long theCardInfoId;
    @ApiModelProperty("对方用户Id")
    private Long theUserId;
    @ApiModelProperty("对方名字")
    private String theFullName;
    @ApiModelProperty("对方公司")
    private String theCompany;
    @ApiModelProperty("对方职位")
    private String thePosition;
    @ApiModelProperty("对方头像地址")
    private String theHeadPortrait;
    @ApiModelProperty("用户名片交换状态(-1:未申请交换,0:已申请交换对方未处理,1：双方已同意，2：对方已拒绝交换要求，3：对方已申请您未处理，4：您主动拒绝交换要求)")
    private Integer swapState;
    @ApiModelProperty("是否已点赞")
    private boolean liked;
}