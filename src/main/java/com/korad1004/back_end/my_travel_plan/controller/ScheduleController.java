package com.korad1004.back_end.my_travel_plan.controller;

import com.korad1004.back_end.my_travel_plan.dto.CreateCourseDto;
import com.korad1004.back_end.my_travel_plan.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
@AllArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    //스케줄 만들기
    @PostMapping
    public ResponseEntity<?> createSchedule(@RequestBody CreateCourseDto createCourseDto){
        try{
            return ResponseEntity.ok(scheduleService.createSchedule(createCourseDto));
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    //해당 코드에 대한 여행 일정 가져 오기
    @GetMapping("/{travel_code}")
    public ResponseEntity<List<Object>> getScheduleOfCode(@PathVariable(name="travel_code") String code){

        return ResponseEntity.ok(scheduleService.getScheduleOfCode(code));
    }


    //스케줄 삭제
    @DeleteMapping("{travel_code}")
    public ResponseEntity<?> deleteScheduleOfCode(@PathVariable(name="travel_code") String code){
            try{
                scheduleService.deleteScheduleOfCode(code);
            }catch (RuntimeException e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }
        return ResponseEntity.noContent().build();
    }

    //스케줄 수정하기
    @PatchMapping("{travel_code}")
    public ResponseEntity<?> updateScheduleOfCode(@PathVariable(name="travel_code") String code, @RequestBody CreateCourseDto createCourseDto){
                try{
                    scheduleService.updateScheduleOfCode(code,createCourseDto);
                }
                catch (RuntimeException e){
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
                }

            return ResponseEntity.ok().build();
    }


}
