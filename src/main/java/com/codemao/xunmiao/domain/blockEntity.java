package com.codemao.xunmiao.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "tbl_block_info")
public class blockEntity {
    @TableId(value = "id")
    private Integer id;

    @TableId(value = "total")
    private Integer total;

    @TableId(value = "floor")
    private Integer floor;
}
