package com.codemao.xunmiao.service.Impl;

import com.codemao.xunmiao.domain.staffEntity;
import com.codemao.xunmiao.mapper.StaffInfoMapper;
import com.codemao.xunmiao.service.seatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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

    @Override
    public List<staffEntity> listFloorInfo(Integer floor) {
        List<staffEntity> staffInfos =  staffInfoMapper.listFloorInfo(floor);
        return staffInfos != null ? staffInfos : null;
    }

    @Override
    public List<staffEntity> ListStaffByFloorAndBlock(Integer floor, Integer block) {
        List<staffEntity> staffInfos = staffInfoMapper.ListStaffByfloorAndblockId(floor, block);
        return staffInfos != null ? staffInfos : null;
    }
}

