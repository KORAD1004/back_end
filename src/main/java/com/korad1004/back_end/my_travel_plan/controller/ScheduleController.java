package com.korad1004.back_end.my_travel_plan.controller;

import com.korad1004.back_end.my_travel_plan.dto.CreateCourseDto;
import com.korad1004.back_end.my_travel_plan.service.ScheduleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/schedule")
@AllArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    //스케줄 만들기
    @PostMapping
    public void createSchedule(@RequestBody CreateCourseDto createCourseDto) throws Exception{
        try{
        scheduleService.createSchedule(createCourseDto);
        } catch (Exception e) {
            throw new RuntimeException("암호 화가 안 됐어요 you know?",e);
        }
    }

}
