package com.codemao.xunmiao.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName(value = "tbl_staff_info")
public class staffEntity {
    @TableId(value = "id")
    private String id;

    @ApiModelProperty("员工姓名")
    private String name;

    @ApiModelProperty("所在楼层")
    private Integer floor;

    @ApiModelProperty("所在小组")
    private Integer block;

    @ApiModelProperty("所在座位号")
    private Integer seat;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
