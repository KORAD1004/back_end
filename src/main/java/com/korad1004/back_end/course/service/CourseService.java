package com.korad1004.back_end.course.service;

import lombok.AllArgsConstructor;
import com.korad1004.back_end.course.dto.CreateCourseNameDto;
import com.korad1004.back_end.course.entity.Course;
import com.korad1004.back_end.course.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    @Transactional
    public Course createCourseName(CreateCourseNameDto createCourseNameDto){

        Course course=new Course();

        course.setCourseName(createCourseNameDto.getCourseName());

        return courseRepository.save(course);

    }
}
