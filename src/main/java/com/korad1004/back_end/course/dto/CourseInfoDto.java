package com.korad1004.back_end.course.dto;

import com.korad1004.back_end.course.entity.CoursePlace;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseInfoDto {


    private Integer number;

    private String image;

    private String title;

    private String address;

    private String latitude;

    private String longitude;


    public static CourseInfoDto from(CoursePlace coursePlace){

        CourseInfoDto courseInfoDto=new CourseInfoDto();

        courseInfoDto.setNumber(courseInfoDto.getNumber());
        courseInfoDto.setImage(courseInfoDto.getImage());
        courseInfoDto.setTitle(courseInfoDto.getTitle());
        courseInfoDto.setAddress(courseInfoDto.getAddress());
        courseInfoDto.setLatitude(courseInfoDto.getLatitude());
        courseInfoDto.setLongitude(courseInfoDto.getLongitude());

        return courseInfoDto;

    }
}
