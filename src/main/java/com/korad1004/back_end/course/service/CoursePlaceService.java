package com.korad1004.back_end.course.service;

import com.korad1004.back_end.category.entity.Hotspot;
import com.korad1004.back_end.category.repository.HotspotRepository;
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

    private final HotspotRepository hotspotRepository;

    //코스이름 선택하여 코스 짜주는 로직
    public void createPlaceOfCourse(Long id ,Integer number,Long hotspot_id){

        CoursePlace coursePlace =new CoursePlace();

        //외래키 참조한 course의 저장소에서 데이터 불러옴
        Optional<Course> optionalCourse = courseRepository.findById(id);
        Optional<Hotspot> optionalHotspot=hotspotRepository.findById(hotspot_id);

        if(optionalCourse.isPresent() && optionalHotspot.isPresent()){

            Course  course = optionalCourse.get();
            Hotspot hotspot=optionalHotspot.get();
            coursePlace.setCourse(course);
            coursePlace.setNumber(number);
            coursePlace.setHotspot(hotspot);

            coursePlaceRepository.save(coursePlace);
        }

    }

    //코스 선택시 해당 코스에 대한 정보를 넘겨주는 엔드포인트
    public List<CourseInfoDto> getCoursePlace(Long id){

        List<CourseInfoDto> courseInfoDtoList =new ArrayList<>();
        Optional<Course> optionalCourse=courseRepository.findById(id); //코스 이름

        //해당 코스가 존재시
        if(optionalCourse.isPresent()) {

            //
            List<CoursePlace> coursePlaceList = coursePlaceRepository.findByCourse(optionalCourse.get());

            CourseInfoDto courseInfoDto;
            for(CoursePlace coursePlace:coursePlaceList) {

                Optional<Hotspot> optionalHotspot= hotspotRepository.findById(coursePlace.getHotspot().getId());

                if(optionalHotspot.isPresent()) {
                    Hotspot hotspot=optionalHotspot.get();

                    courseInfoDto=CourseInfoDto.from(hotspot);

                    courseInfoDto.setNumber(coursePlace.getNumber());

                    courseInfoDtoList.add(courseInfoDto);
                }
            }
            return courseInfoDtoList;
        }
        return null;
    }
}
