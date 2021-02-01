package com.codemao.xunmiao.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class seatController {
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/seat-manage/add/staff")
    public String addStaff(
            @RequestParam(value = "id", required = false) String id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "floor", required = false) Integer floor,
            @RequestParam(value = "seat", required = false) Integer seat
    ) {
        // TODO 某个座位添加员工信息
        return "hello";
    }

    @RequestMapping("/seat-manage/delete/staff")
    public void deleteStaff(
            @RequestParam(value = "floor", required = false) Integer floor,
            @RequestParam(value = "seat", required = false) Integer seat
    ) {
        // TODO 删除某个座位员工信息
    }

    // ....
}
