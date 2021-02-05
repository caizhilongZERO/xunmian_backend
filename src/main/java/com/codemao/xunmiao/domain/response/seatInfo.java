package com.codemao.xunmiao.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class seatInfo {
    @JsonProperty("seat_id")
    private Integer seatId;

    @JsonProperty("status")
    private boolean status;

    @JsonProperty("staff_id")
    private String staffId;

    @JsonProperty("staff_name")
    private String staffName;
}
