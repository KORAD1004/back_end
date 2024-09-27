package com.korad1004.back_end.course_place.controller;

import lombok.AllArgsConstructor;
import com.korad1004.back_end.course_place.dto.CourseInfoDto;
import com.korad1004.back_end.course_place.service.CoursePlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/course-place")
@AllArgsConstructor
public class CoursePlaceController {

    private final CoursePlaceService coursePlaceService;

    //코스이름 선택하여 코스 짜주는 api
    @PostMapping("{course_id}")
    public ResponseEntity<Void> createCourse(@PathVariable(name="course_id") Long id, @RequestBody CourseInfoDto courseInfoDto){

        if(coursePlaceService.createPlaceOfCourse(id, courseInfoDto))
            return ResponseEntity.status(HttpStatus.CREATED).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //원하는 코스를 선택시 해당 코스에 대한 경로 정보 api
    @GetMapping("{course_id}")
    public ResponseEntity<List<CourseInfoDto>> getCoursePlaceOfCourse(@PathVariable(name="course_id") Long id){

        return ResponseEntity.ok(coursePlaceService.getCoursePlace(id));
    }

}
