package com.codemao.xunmiao.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class blockInfo {
    @JsonProperty("block_id")
    private Integer blockId = 0;

    @JsonProperty("seat_list")
    private List<seatInfo> seatList = new ArrayList<>();
}
