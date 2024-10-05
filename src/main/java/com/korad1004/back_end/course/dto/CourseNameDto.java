package com.korad1004.back_end.course.dto;

import com.korad1004.back_end.course.entity.Course;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseNameDto {

    private String courseName;

    public static CourseNameDto from(Course course){
        CourseNameDto courseNameDto =new CourseNameDto();
        courseNameDto.setCourseName(course.getCourseName());
        return courseNameDto;
    }
}
