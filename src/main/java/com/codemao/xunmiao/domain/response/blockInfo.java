package com.codemao.xunmiao.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class blockInfo {
    @JsonProperty("floor_id")
    private Integer floorId = 0;

    @JsonProperty("block_id")
    private Integer blockId = 0;

    @JsonProperty("total")
    private Integer total = 0;

    @JsonProperty("rows")
    private Integer rows = 0;

    @JsonProperty("col")
    private Integer col = 0;

    @JsonProperty("seat_list")
    private List<seatInfo> seatList = new ArrayList<>();

    public blockInfo(Integer floor, Integer block) {
        floorId = floor;
        blockId = block;
        total = 0;
        rows = 0;
        col = 0;
        seatList = new ArrayList<>();
    }
}
