package com.codemao.xunmiao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codemao.xunmiao.domain.staffEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatInfoMapper extends BaseMapper<staffEntity> {
    void deleteStaff(
            @Param("seat_id") Integer seat_id,
            @Param("block_id") Integer block_id,
            @Param("floor_id") Integer floor_id
    );

    List<staffEntity> listFloorInfo(
            @Param("floor") Integer floor
    );

    List<staffEntity> ListStaffByfloorAndblockId(
            @Param("floor") Integer floor,
            @Param("block") Integer block
    );

    List<staffEntity> ListStaffInfoByIdOrName(
            @Param("keyword") String keyword
    );
}
