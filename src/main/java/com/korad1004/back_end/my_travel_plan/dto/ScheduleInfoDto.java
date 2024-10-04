package com.korad1004.back_end.my_travel_plan.dto;

import com.korad1004.back_end.my_travel_plan.entity.Schedule;
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

    public static ScheduleInfoDto from(Schedule schedule){
        ScheduleInfoDto scheduleInfoDto = new ScheduleInfoDto();

        scheduleInfoDto.setCode(schedule.getCode());
        scheduleInfoDto.setTravelName(scheduleInfoDto.getTravelName());
        scheduleInfoDto.setHeadCount(scheduleInfoDto.getHeadCount());
        scheduleInfoDto.setStartDate(scheduleInfoDto.getStartDate());
        scheduleInfoDto.setEndDate(scheduleInfoDto.getEndDate());
        scheduleInfoDto.setDays(scheduleInfoDto.getDays());

        return scheduleInfoDto;
    }
}
