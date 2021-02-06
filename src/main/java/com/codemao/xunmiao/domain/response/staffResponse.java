package com.codemao.xunmiao.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class staffResponse {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("floor_id")
    private Integer floor_id;

    @JsonProperty("block_id")
    private Integer block_id;

    @JsonProperty("seat_id")
    private Integer seat_id;
}
