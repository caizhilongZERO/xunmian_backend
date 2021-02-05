package com.codemao.xunmiao.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class blockInfo {
    @JsonProperty("block_id")
    private Integer blockId;

    @JsonProperty("seat_list")
    private List<seatInfo> seatList;
}
