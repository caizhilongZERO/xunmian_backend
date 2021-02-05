package com.codemao.xunmiao.service.Impl;

import com.codemao.xunmiao.domain.staffEntity;
import com.codemao.xunmiao.mapper.StaffInfoMapper;
import com.codemao.xunmiao.service.seatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class seatServiceImpl implements seatService {
    @Autowired
    StaffInfoMapper staffInfoMapper;

    @Override
    public void addSeat(
            String name,
            String id,
            Integer floor,
            Integer block,
            Integer seat
    ) {
        staffEntity staffEntity = new staffEntity();
        staffEntity.setName(name);
        staffEntity.setId(id);
        staffEntity.setFloor(floor);
        staffEntity.setBlock(block);
        staffEntity.setSeat(seat);
        staffInfoMapper.insert(staffEntity);

    }

    @Override
    public void deleteSeat(
            Integer seat_id,
            Integer block_id,
            Integer floor_id
    ) {
        staffInfoMapper.deleteStaff(seat_id, block_id, floor_id);
    }
}

