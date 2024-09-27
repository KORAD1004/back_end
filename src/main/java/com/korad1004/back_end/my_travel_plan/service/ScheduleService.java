package com.korad1004.back_end.my_travel_plan.service;

import lombok.AllArgsConstructor;
import com.korad1004.back_end.my_travel_plan.dto.ScheduleInfoDto;
import com.korad1004.back_end.my_travel_plan.entity.Schedule;
import com.korad1004.back_end.my_travel_plan.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public Schedule createSchedule(ScheduleInfoDto scheduleInfoDto){

        Schedule schedule =new Schedule();

        schedule.setCode(scheduleInfoDto.getCode());
        schedule.setTravelName(scheduleInfoDto.getTravelName());
        schedule.setHeadCount(scheduleInfoDto.getHeadCount());

        //여기 두개는 나중에 수정 (일자 잘못 입력시 비교 연산 해야됨)
        schedule.setStartDate(scheduleInfoDto.getStartDate());
        schedule.setEndDate(scheduleInfoDto.getEndDate());

        schedule.setDays(scheduleInfoDto.getDays());

        return scheduleRepository.save(schedule);
    }
}
