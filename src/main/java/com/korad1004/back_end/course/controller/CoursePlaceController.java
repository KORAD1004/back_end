package com.korad1004.back_end.course.controller;

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
public class CoursePlaceController {

    private final CoursePlaceService coursePlaceService;

    //코스이름 선택 & 동선 순서 & 가볼만한 곳에 등록 되어있는 장소 이름 post 요청시 해당 코스 항목에 들어감
    @PostMapping("{course_id}/{number}/{hotspot_title}")
    public ResponseEntity<?> createCourse(@PathVariable(name="course_id") Long id, @PathVariable(name="number") Integer number,@PathVariable(name="hotspot_title") String title){

        coursePlaceService.createPlaceOfCourse(id,number,title);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    //원하는 코스를 선택시 해당 코스에 대한 경로 정보 api
    @GetMapping("{course_id}")
    public ResponseEntity<List<CourseInfoDto>> getCoursePlaceOfCourse(@PathVariable(name="course_id") Long id){

        return ResponseEntity.ok(coursePlaceService.getCoursePlace(id));
    }

}
