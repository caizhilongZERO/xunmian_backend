package com.codemao.xunmiao.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class floorInfo {
    @JsonProperty("floor_id")
    private Integer floorId;

    @JsonProperty("block_list")
    private List<blockInfo> blockList;
}
