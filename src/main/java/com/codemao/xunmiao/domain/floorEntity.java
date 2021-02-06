package com.codemao.xunmiao.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "tbl_floor_info")
public class floorEntity {
    @TableId(value = "floor")
    private Integer floor;

    @TableId(value = "total")
    private Integer total;
}
