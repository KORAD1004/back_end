package com.korad1004.back_end.course.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import com.korad1004.back_end.course.dto.CourseInfoDto;
import com.korad1004.back_end.course.service.CoursePlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/course-place")
@AllArgsConstructor
@Tag(name = "course_place")
public class CoursePlaceController {

    private final CoursePlaceService coursePlaceService;

    //코스이름 선택 & 동선 순서 & 가볼만한 곳에 등록 되어있는 장소 이름 post 요청시 해당 코스 항목에 들어감
    //입력 항목 : 코스 아이디, 동선 순서, 장소 이름
    @PostMapping("{course_id}/{number}/{hotspot_id}")
    @Operation(
            summary = "<테마별 추천 코스> 원하는 테마 제목에 맞는 코스를 등록 가능",
            description = "테마 Id + 코스 동선 Ex) 1번 장소 or 2번 장소 number 값" +
                    " 데이터 베이스에 저장된 각 핫스팟 Id를 Path로 입력시 저장됨"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "원하는 테마 제목에 맞는 코스 등록 성공"
            )
    })
    public ResponseEntity<?> createCourse(@PathVariable(name="course_id") Long id, @PathVariable(name="number") Integer number,@PathVariable(name="hotspot_id") Long hotspot_id){

        coursePlaceService.createPlaceOfCourse(id,number,hotspot_id);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    //원하는 코스를 선택시 해당 코스에 대한 경로 정보 api
    @GetMapping("{course_id}")
    @Operation(
            summary = "<테마별 추천 코스> 테마 Id 입력시 해당 테마에 저장된 장소 리스트 업",
            description = "Path에 Id 입력 시 해당 Id에 대한 코스를 리스트 형식으로 불러옴"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "해당 테마에 등록 된 장소들 잘 불러옴",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CourseInfoDto.class)
                    )
            )
    })
    public ResponseEntity<List<CourseInfoDto>> getCoursePlaceOfCourse(@PathVariable(name="course_id") Long id){

        return ResponseEntity.ok(coursePlaceService.getCoursePlace(id));
    }

}
