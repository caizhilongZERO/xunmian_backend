package com.codemao.xunmiao.utils;

import com.codemao.xunmiao.domain.response.seatInfo;
import com.codemao.xunmiao.domain.staffEntity;

import java.util.ArrayList;
import java.util.List;

public class tools {
    public static List<seatInfo> staffEntityTOseatInfoList(List<staffEntity> staffList) {
        List<seatInfo> seatInfoList = new ArrayList<>();
        staffList.forEach(item -> {
            seatInfo seatInfo = new seatInfo();
            seatInfo.setSeatId(item.getSeat());
            seatInfo.setStaffId(item.getId());
            seatInfo.setStaffName(item.getName());
            seatInfoList.add(seatInfo);
        });
        return seatInfoList;
    }


}
