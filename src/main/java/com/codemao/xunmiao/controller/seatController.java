package com.codemao.xunmiao.controller;

import com.codemao.xunmiao.domain.response.blockInfo;
import com.codemao.xunmiao.domain.response.floorInfo;
import com.codemao.xunmiao.domain.response.staffResponse;
import com.codemao.xunmiao.service.seatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class seatController {

    @Autowired
    private seatService seatService;

    @RequestMapping("/floor")
    public floorInfo getFloorInfo(
            @RequestParam(value = "floor") Integer floor
    ) {
        // TODO 返回楼层信息
        return new floorInfo();
    }

    @RequestMapping("/block")
    public blockInfo getBlockInfo(
            @RequestParam("floor") Integer floor,
            @RequestParam("blockid") Integer blockid
    )   {
        // TODO 返回分组信息
        return new blockInfo();
    }

    @RequestMapping("/search")
    public staffResponse searchStaff(
            @RequestParam("keyword") String keyword
    ){
        // TODO 搜索员工信息
        return new staffResponse();
    }
    @RequestMapping("/seat")
    public boolean addSeat(
            @RequestParam("name") String name,
            @RequestParam("id") String id,
            @RequestParam("floor") Integer floor,
            @RequestParam("block") Integer block,
            @RequestParam("seat") Integer seat
    ) {
        seatService.deleteSeat(seat, block, floor);
        try {
            seatService.addSeat(name, id, floor, block, seat);
        } catch (DuplicateKeyException e) {
            log.error("insert seat error:", e);
            return false;
        }
        return true;
    }

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
