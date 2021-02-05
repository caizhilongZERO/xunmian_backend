package com.codemao.xunmiao.service;

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
}
