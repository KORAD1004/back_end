package com.korad1004.back_end.scrap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NationWideRadiationAverageDto {
    @JsonProperty(value = "지역")
    private String region;
    private Double avgRad;
}
