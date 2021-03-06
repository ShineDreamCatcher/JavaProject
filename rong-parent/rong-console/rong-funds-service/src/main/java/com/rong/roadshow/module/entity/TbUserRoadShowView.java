package com.rong.roadshow.module.entity;

import com.rong.common.module.BaseEntity;
import com.vitily.mybatis.core.annotation.Column;
import com.vitily.mybatis.core.annotation.Table;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description : 会员预约路演记录
 * @author      : lether
 * @createDate  : 2020-02-06
 */
@Table("`tb_user_road_show_view`")
@Data()
@Accessors(chain = true)
public class TbUserRoadShowView extends BaseEntity<TbUserRoadShowView> {
    /**
     * 用户id
     */
    @Column("`user_id`")
    private Long userId;

    /**
     * 路演id
     */
    @Column("`road_show_id`")
    private Long roadShowId;
}