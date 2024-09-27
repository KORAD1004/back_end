package com.korad1004.back_end.my_travel_plan.controller;


import lombok.AllArgsConstructor;
import com.korad1004.back_end.my_travel_plan.dto.ScheduleInfoDto;
import com.korad1004.back_end.my_travel_plan.entity.Schedule;
import com.korad1004.back_end.my_travel_plan.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/schedule")
@AllArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@RequestBody ScheduleInfoDto scheduleInfoDto){

        Schedule schedule=scheduleService.createSchedule(scheduleInfoDto);

        return ResponseEntity.ok(schedule);
    }

    //해당 코드에 대한 여행일정, 일차, 인원수 보여주는 getmapping


}
