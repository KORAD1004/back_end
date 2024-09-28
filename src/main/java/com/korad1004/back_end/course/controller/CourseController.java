package com.korad1004.back_end.course.controller;


import lombok.AllArgsConstructor;
import com.korad1004.back_end.course.dto.CreateCourseNameDto;
import com.korad1004.back_end.course.entity.Course;
import com.korad1004.back_end.course.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/course")
@RestController
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    //코스 이름 등록 대충 3개 정도 등록 예정
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody CreateCourseNameDto createCourseNameDto){
        Course course = courseService.createCourseName(createCourseNameDto);

        return ResponseEntity.ok(course);
    }

}
