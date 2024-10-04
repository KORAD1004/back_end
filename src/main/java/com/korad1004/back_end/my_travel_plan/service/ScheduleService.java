package com.korad1004.back_end.my_travel_plan.service;

import com.korad1004.back_end.my_travel_plan.repository.RouteRepository;
import lombok.AllArgsConstructor;
import com.korad1004.back_end.my_travel_plan.dto.ScheduleInfoDto;
import com.korad1004.back_end.my_travel_plan.entity.Schedule;
import com.korad1004.back_end.my_travel_plan.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final RouteRepository routeRepository;

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

    public List<Object> getCourseOfMyTrip(String code){

        List<Object> mixedList = new ArrayList<>();

        mixedList.add(scheduleRepository.findByCode(code));
        mixedList.add(routeRepository.findByCode(code));

        return mixedList;

    }
}
