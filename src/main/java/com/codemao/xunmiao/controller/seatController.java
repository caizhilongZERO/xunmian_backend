package com.codemao.xunmiao.controller;

import com.codemao.xunmiao.domain.blockEntity;
import com.codemao.xunmiao.domain.floorEntity;
import com.codemao.xunmiao.domain.response.blockInfo;
import com.codemao.xunmiao.domain.response.floorInfo;
import com.codemao.xunmiao.domain.response.seatInfo;
import com.codemao.xunmiao.domain.response.staffResponse;
import com.codemao.xunmiao.domain.staffEntity;
import com.codemao.xunmiao.mapper.FloorInfoMapper;
import com.codemao.xunmiao.service.blockService;
import com.codemao.xunmiao.service.seatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Slf4j
@RestController
public class seatController {

    @Autowired
    private seatService seatService;

    @Autowired
    private blockService blockService;

    @Autowired
    private FloorInfoMapper floorInfoMapper;

    /**
     * 获取楼层信息
     * @param floor 楼层号
     * @return
     */
    @RequestMapping("/floor")
    public floorInfo getFloorInfo(
            @RequestParam(value = "floor") Integer floor
    ) {
        floorEntity floorEntity = floorInfoMapper.selectById(floor);
        floorInfo floorInfo = new floorInfo();
        floorInfo.setBlockList(new ArrayList<>());
        floorInfo.setFloorId(floor);

        if (floorEntity.getTotal() == null) return floorInfo;
        for (int i = 1;i <= floorEntity.getTotal(); i++) {
            blockInfo blockInfo = getBlockInfo(floor, i);
            if (blockInfo == null) {
                floorInfo.getBlockList().add(new blockInfo(floor, i));
            } else {
                floorInfo.getBlockList().add(blockInfo);
            }
        }
        return floorInfo;
    }

    /**
     * 获取小组信息
     * @param floor 楼层号
     * @param blockid 组号
     * @return
     */
    @RequestMapping("/block")
    public blockInfo getBlockInfo(
            @RequestParam("floor") Integer floor,
            @RequestParam("blockid") Integer blockid
    )   {
        blockEntity block = blockService.getBlockEntity(blockid, floor);
        blockInfo blockInfo = new blockInfo(floor, blockid);
        Set<Integer> assignedSeats;
        Map<Integer, staffEntity> staffMapper = new HashMap<>();
        blockInfo.setSeatList(new ArrayList<>());

        if (block == null) return blockInfo;
        List<staffEntity> staffInfos = seatService.ListStaffByFloorAndBlock(floor, blockid);
        blockInfo.setRows(block.getRows());
        blockInfo.setCol(block.getCol());
        blockInfo.setTotal(block.getTotal());
        staffInfos.forEach(item -> {
            staffMapper.put(item.getSeat(), item);
        });
        assignedSeats = staffMapper.keySet();
        for (int i = 1; i <= block.getTotal(); i++) {
            seatInfo seatinfo = new seatInfo();
            seatinfo.setSeatId(i);
            if (assignedSeats.contains(i)) {
                seatinfo.setStaffName(staffMapper.get(i).getName());
                seatinfo.setStatus(true);
                seatinfo.setStaffId(staffMapper.get(i).getId());
            } else {
                seatinfo.setStaffName("");
                seatinfo.setStatus(false);
                seatinfo.setStaffId("");
            }
            blockInfo.getSeatList().add(seatinfo);
        }
        return blockInfo;
    }

    /**
     * 查找员工
     * @param keyword 工号或姓名关键字
     * @return
     */
    @RequestMapping("/search")
    public List<staffResponse> searchStaff(
            @RequestParam("keyword") String keyword
    ){
        List<staffResponse> staffInfos = new ArrayList<>();
        List<staffEntity> staffEntitys = seatService.ListStaffByIdOrName(keyword);
        staffEntitys.forEach(item -> {
            staffResponse response = new staffResponse();
            response.setId(item.getId());
            response.setName(item.getName());
            response.setFloor_id(item.getFloor());
            response.setBlock_id(item.getBlock());
            response.setSeat_id(item.getSeat());
            staffInfos.add(response);
        });
        return staffInfos;
    }

    /**
     * 添加座位
     * @param name 姓名
     * @param id    工号
     * @param floor 楼层
     * @param block 小组
     * @param seat  座位
     * @return
     */
    @RequestMapping("/seat")
    public boolean addSeat(
            @RequestParam("name") String name,
            @RequestParam("id") String id,
            @RequestParam("floor") Integer floor,
            @RequestParam("block") Integer block,
            @RequestParam("seat") Integer seat
    ) {
        List<staffResponse> list = searchStaff(id);
        staffResponse staff = null;
        if (list.size() != 0) {
            staff = list.get(0);
            seatService.deleteSeat(staff.getSeat_id(), staff.getBlock_id(), staff.getFloor_id());
        }
        try {
            seatService.addSeat(name, id, floor, block, seat);
        } catch (DuplicateKeyException e) {
            log.error("insert seat error:", e);
            if (staff != null) {
                seatService.addSeat(staff.getName(), staff.getId(), staff.getFloor_id(), staff.getBlock_id(), staff.getSeat_id());
            }
            return false;
        }

        return true;
    }

    /**
     * 离座
     * @param name 姓名
     * @param id    工号
     * @param floor 楼层号
     * @param block 小组号
     * @param seat  座位号
     * @return
     */
    @RequestMapping("/leave")
    public boolean deleteStaff(
            @RequestParam("name") String name,
            @RequestParam(value = "id") String id,
            @RequestParam(value = "floor") Integer floor,
            @RequestParam(value = "block") Integer block,
            @RequestParam(value = "seat") Integer seat
    ) {
        seatService.deleteSeat(seat, block, floor);
        return true;
    }
}
