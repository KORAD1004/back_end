package com.korad1004.back_end.my_travel_plan.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScheduleInfoDto {

    private String code;

    private String travelName;

    private Integer headCount;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer days;
}
