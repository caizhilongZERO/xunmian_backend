package com.codemao.xunmiao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codemao.xunmiao.domain.blockEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockInfoMapper extends BaseMapper<blockEntity> {
    blockEntity getBlockEntityByidAndfloor(
            @Param("id") Integer id,
            @Param("floor") Integer floor
    );
}
