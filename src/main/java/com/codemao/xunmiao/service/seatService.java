package com.codemao.xunmiao.service;

import com.codemao.xunmiao.domain.staffEntity;

import java.util.List;

public interface seatService {
    /**
     * 添加座位
     * @param name 姓名
     * @param id    工号
     * @param floor 楼层号
     * @param block 小组号
     * @param seat  座位号
     */
    void addSeat(
            String name,
            String id,
            Integer floor,
            Integer block,
            Integer seat
    );

    /**
     * 删除座位
     * @param seat_id   座位号
     * @param block_id  小组号
     * @param floor_id  楼层号
     */
    void deleteSeat(
            Integer seat_id,
            Integer block_id,
            Integer floor_id
    );

    /**
     * 通过姓名或者工号查找员工信息
     * @param keyword 姓名或者工号
     * @return
     */
    List<staffEntity> ListStaffByIdOrName(String keyword);

    /**
     * 列出小组详情
     * @param floor 楼层号
     * @param block 小组号
     * @return
     */
    List<staffEntity> ListStaffByFloorAndBlock(Integer floor, Integer block);


}
