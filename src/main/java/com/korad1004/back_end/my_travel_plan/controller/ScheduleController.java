package com.korad1004.back_end.my_travel_plan.controller;

import com.korad1004.back_end.my_travel_plan.dto.CreateCourseDto;
import com.korad1004.back_end.my_travel_plan.dto.GetSpotInfoOfMyTravel;
import com.korad1004.back_end.my_travel_plan.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    //스케줄 만들기
    @PostMapping
    @Operation(
            summary = "<나만의 여행 일정 짜기> 나만의 여행 일정 등록 가능 API",
            description = " 해당 여행 일정을 조회 가능한 코드가 return 됨"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "나만의 여행 일정 등록 성공",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CreateCourseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "잘못된 입력 으로 인해 등록 실패" +
                            " or 시간의 입력 순서가 잘못 됨 cf) 빈 시간은 들어갈 수 있음 하지만 둘다 비어야 됨"
            )
    })
    public ResponseEntity<?> createSchedule(@RequestBody CreateCourseDto createCourseDto){
        try{
            return ResponseEntity.ok(scheduleService.createSchedule(createCourseDto));
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    //해당 코드에 대한 여행 일정 가져 오기
    @GetMapping("/{travel_code}")
    @Operation(
            summary = "<나만의 여행 일정 짜기> 생성된 코드에 대한 나만의 여행 일정 정보를 가져 오는 API",
            description = "생성된 8자리 숫자를 Path로 기입시 해당 코드에 관련된 여행 정보를 보여줌"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "해당 코드에 관련된 나의 여행 일정을 잘 불러옴",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(type = "array",implementation = GetSpotInfoOfMyTravel.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "해당 코드에 관한 정보가 데이터베이스에 없음"
            )
    })
    public ResponseEntity<List<Object>> getScheduleOfCode(@PathVariable(name="travel_code") String code){

        return ResponseEntity.ok(scheduleService.getScheduleOfCode(code));
    }


    //스케줄 삭제
    @DeleteMapping("{travel_code}")
    @Operation(
            summary = "<나만의 여행 일정 짜기> 해당 코드 입력시 스케줄 삭제 API",
            description = "생성된 코드를 Path 입력시 해당 스케줄 삭제"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "해당 스케줄이 잘 삭제됨"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "해당 코드가 데이터 베이스에 존재 하지 않음"
            )
    })
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
    @Operation(
            summary = "<나만의 여행 일정 짜기> 해당 코드 입력시 스케줄 수정 API",
            description = "생성된 코드를 Path 입력시 해당 스케줄 수정"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "해당 스케줄이 잘 수정됨",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CreateCourseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "해당 코드가 데이터 베이스에 존재 하지 않음"
            )
    })
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
