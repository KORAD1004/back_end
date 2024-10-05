package com.korad1004.back_end.course.controller;


import com.korad1004.back_end.course.dto.CourseNameDto;
import lombok.AllArgsConstructor;
import com.korad1004.back_end.course.entity.Course;
import com.korad1004.back_end.course.service.CourseService;
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
public class CourseController {

    private final CourseService courseService;

    //코스 이름 등록 대충 3개 정도 등록 예정
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody CourseNameDto courseNameDto){
        courseService.createCourseName(courseNameDto);

        return ResponseEntity.created(URI.create("api/course")).build();
    }

    //코스 이름 전체 출력
    @GetMapping
    public ResponseEntity<List<CourseNameDto>> getAllCourseName(){
        return ResponseEntity.ok(courseService.getAllCourseName());
    }

    //코스 id에 대한 코스 이름 출력
    @GetMapping("{id}")
    public ResponseEntity<CourseNameDto> getCourseNameById(@PathVariable(name="id") Long id){
        return ResponseEntity.ok(courseService.getCourseNameById(id));
    }

    //원하는 코스 삭제
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable(name="id") Long integer){

        return courseService.deleteCourse(integer);
    }

}
