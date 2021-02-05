package com.codemao.xunmiao.service;

import com.codemao.xunmiao.domain.staffEntity;

import java.util.List;

public interface seatService {
    void addSeat(
            String name,
            String id,
            Integer floor,
            Integer block,
            Integer seat
    );

    void deleteSeat(
            Integer seat_id,
            Integer block_id,
            Integer floor_id
    );

    List<staffEntity> listFloorInfo(Integer floor);
}
