package com.korad1004.back_end.course.dto;

import com.korad1004.back_end.category.entity.Hotspot;
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

    private String spotURL;

    private String category;


    public static CourseInfoDto from(Hotspot hotspot){

        CourseInfoDto courseInfoDto=new CourseInfoDto();

        courseInfoDto.setImage(hotspot.getImage());
        courseInfoDto.setTitle(hotspot.getTitle());
        courseInfoDto.setAddress(hotspot.getAddress());
        courseInfoDto.setLatitude(hotspot.getLatitude());
        courseInfoDto.setLongitude(hotspot.getLongitude());
        courseInfoDto.setSpotURL(hotspot.getSpotURL());
        courseInfoDto.setCategory(hotspot.getCategory().getCategoryName());

        return courseInfoDto;

    }
}
