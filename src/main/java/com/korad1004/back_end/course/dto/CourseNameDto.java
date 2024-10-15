package com.korad1004.back_end.course.dto;

import com.korad1004.back_end.course.entity.Course;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "코스 이름 반환")
public class CourseNameDto {

    @Schema(description = "코스 이름 ",example = "벅차 오르는 순간, 역사가 깃든 경주 한 바퀴")
    private String courseName;

    public static CourseNameDto from(Course course){
        CourseNameDto courseNameDto =new CourseNameDto();
        courseNameDto.setCourseName(course.getCourseName());
        return courseNameDto;
    }
}
