package com.korad1004.back_end.my_travel_plan.controller;


import lombok.AllArgsConstructor;
import com.korad1004.back_end.my_travel_plan.dto.ScheduleInfoDto;
import com.korad1004.back_end.my_travel_plan.entity.Schedule;
import com.korad1004.back_end.my_travel_plan.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/schedule")
@AllArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    //일정
    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@RequestBody ScheduleInfoDto scheduleInfoDto){

        Schedule schedule=scheduleService.createSchedule(scheduleInfoDto);

        return ResponseEntity.ok(schedule);
    }

    //해당 일정 code에 대한 모든 정보
    @GetMapping("{code}")
    public ResponseEntity<List<Object>> getCourseOfMyTrip(@PathVariable(name = "code") String code){
        return ResponseEntity.ok(scheduleService.getCourseOfMyTrip(code));
    }

    //해당 코드에 대한 여행일정, 일차, 인원수 보여주는 getmapping


}
