package com.korad1004.back_end.course_place.dto;

import com.korad1004.back_end.course_place.entity.CoursePlace;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseInfoDto {


    private String title;


    private String address;


    private String spotUrl;

    public static CourseInfoDto from(CoursePlace coursePlace){

        CourseInfoDto courseInfoDto=new CourseInfoDto();

        courseInfoDto.setTitle(courseInfoDto.getTitle());
        courseInfoDto.setAddress(courseInfoDto.getAddress());
        courseInfoDto.setSpotUrl(courseInfoDto.getSpotUrl());

        return courseInfoDto;

    }
}
