package com.korad1004.back_end.my_travel_plan.controller;

import com.korad1004.back_end.my_travel_plan.dto.CreateCourseDto;
import com.korad1004.back_end.my_travel_plan.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/schedule")
@AllArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    //스케줄 만들기
    @PostMapping
    public ResponseEntity<?> createSchedule(@RequestBody CreateCourseDto createCourseDto) throws Exception{
        try{
            return ResponseEntity.ok(scheduleService.createSchedule(createCourseDto));
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{travel_code}")
    public ResponseEntity<List<Object>> getScheduleOfCode(@PathVariable(name="travel_code") String code){

        return ResponseEntity.ok(scheduleService.getScheduleOfCode(code));
    }

}
