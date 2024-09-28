package com.korad1004.back_end.course.service;

import lombok.AllArgsConstructor;
import com.korad1004.back_end.course.entity.Course;
import com.korad1004.back_end.course.repository.CourseRepository;
import com.korad1004.back_end.course.dto.CourseInfoDto;
import com.korad1004.back_end.course.entity.CoursePlace;
import com.korad1004.back_end.course.repository.CoursePlaceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CoursePlaceService {

    private final CoursePlaceRepository coursePlaceRepository;  //코스정보등록 저장소

    private final CourseRepository courseRepository; //코스이름 저장소

    //코스이름 선택하여 코스 짜주는 로직
    public Boolean createPlaceOfCourse(Long id, CourseInfoDto courseInfoDto){

        CoursePlace coursePlace =new CoursePlace();

        //외래키 참조한 course의 저장소에서 데이터 불러옴
        Optional<Course> optionalCourse = courseRepository.findById(id);

        if(optionalCourse.isPresent()){

            Course  course = optionalCourse.get();

            coursePlace.setTitle(courseInfoDto.getTitle());
            coursePlace.setAddress(coursePlace.getAddress());
            coursePlace.setSpotUrl(coursePlace.getSpotUrl());
            coursePlace.setCourse(course);

            coursePlaceRepository.save(coursePlace);

            return true;
        }
        return false;

    }

    //코스 선택시 해당 코스에 대한 정보를 넘겨주는 Logic
    public List<CourseInfoDto> getCoursePlace(Long id){

        CourseInfoDto courseInfoDto;
        List<CourseInfoDto> courseInfoDtoList =new ArrayList<>();
        Optional<Course> optionalCourse=courseRepository.findById(id); //코스 이름

        if(optionalCourse.isPresent()) {
            List<CoursePlace> coursePlaces=coursePlaceRepository.findByCourse(optionalCourse.get());

            for(CoursePlace coursePlace:coursePlaces){
                courseInfoDto = CourseInfoDto.from(coursePlace); //코스가 나와야함
                courseInfoDtoList.add(courseInfoDto);
            }
            return courseInfoDtoList;
        }

        return null;

    }

}
