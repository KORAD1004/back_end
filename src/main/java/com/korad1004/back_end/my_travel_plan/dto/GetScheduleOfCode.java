package com.korad1004.back_end.my_travel_plan.dto;


import com.korad1004.back_end.my_travel_plan.entity.Schedule;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetScheduleOfCode {

    private String code;

    private String travelName;

    private Integer headCount;

    private String startDate;

    private String endDate;

    private String days;

    //number,[hotspot_image,hotspot_title,hotspot_address,hotspot_latitude,hotspot_longitude],memo

    public static GetScheduleOfCode from(Schedule schedule){

        GetScheduleOfCode getScheduleOfCode = new GetScheduleOfCode();
        getScheduleOfCode.setCode(schedule.getCode());
        getScheduleOfCode.setTravelName(schedule.getTravelName());
        getScheduleOfCode.setHeadCount(schedule.getHeadCount());
        getScheduleOfCode.setStartDate(schedule.getStartDate());
        getScheduleOfCode.setEndDate(schedule.getEndDate());
        getScheduleOfCode.setDays(schedule.getDays());

        return getScheduleOfCode;
    }
}
