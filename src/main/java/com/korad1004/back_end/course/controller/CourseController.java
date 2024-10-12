package com.korad1004.back_end.course.controller;


import com.korad1004.back_end.course.dto.CourseNameDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import com.korad1004.back_end.course.entity.Course;
import com.korad1004.back_end.course.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RequestMapping("api/course")
@RestController
@AllArgsConstructor
@Tag(name = "course")
public class CourseController {

    private final CourseService courseService;

    //코스 이름 등록 대충 3개 정도 등록 예정
    @Operation(
            summary = "<테마 별 추천 코스>코스 제목 등록 API",
            description = "테마 제목만 등록 가능"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "테마 제목 등록 완료",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CourseNameDto.class)
                    )
            )
    })
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody CourseNameDto courseNameDto){
        courseService.createCourseName(courseNameDto);

        return ResponseEntity.created(URI.create("api/course")).build();
    }

    //코스 이름 전체 출력
    @Operation(
            summary = "<테마별 추천 코스> 저장된 모든 테마 이름 받아 오는 API",
            description = "Try it out -> execute 실행 시 저장된 모든 테마 제목을 받을 수 있음"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "저장 된 테마 이름 잘 받아옴",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(type = "array",implementation = CourseNameDto.class)
                    )
            )
    })
    @GetMapping
    public ResponseEntity<List<CourseNameDto>> getAllCourseName(){
        return ResponseEntity.ok(courseService.getAllCourseName());
    }

    //코스 id에 대한 코스 이름 출력
    @Operation(
            summary = "<테마별 추천 코스> 테마 Id 입력시 해당 테마 이름 불러옴",
            description = "Path에 Id 입력 시 해당 Id에 대한 테마 제목을 받을 수 있음"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "해당 테마 이름을 잘 받아옴",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation =CourseNameDto.class )
                    )
            )
    })
    @GetMapping("{id}")
    public ResponseEntity<CourseNameDto> getCourseNameById(@PathVariable(name="id") Long id){
        return ResponseEntity.ok(courseService.getCourseNameById(id));
    }

    //원하는 코스 삭제
    @Operation(
            summary = "<테마별 추천 코스> 테마 Id 입력시 해당 테마에 대한 저장된 테마 이름 및 장소 전부 삭제",
            description = "Path에 Id 입력 시 해당 Id에 대한 코스를 삭제함"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "해당 아이디에 관한 테마 추천코스가 잘 삭제됨"
            )
    })
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable(name="id") Long integer){

        return courseService.deleteCourse(integer);
    }

}
