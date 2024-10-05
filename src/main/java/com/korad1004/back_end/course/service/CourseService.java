package com.korad1004.back_end.course.service;

import com.korad1004.back_end.course.dto.CourseNameDto;
import lombok.AllArgsConstructor;
import com.korad1004.back_end.course.entity.Course;
import com.korad1004.back_end.course.repository.CourseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    //코스 이름 저장하기
    @Transactional
    public void createCourseName(CourseNameDto courseNameDto){

        Course course=new Course();

        course.setCourseName(courseNameDto.getCourseName());

        courseRepository.save(course);
    }

    //코스 전체 이름 출력
    public List<CourseNameDto> getAllCourseName(){
        CourseNameDto courseNameDto;
        List<Course> courseList = courseRepository.findAll();
        List<CourseNameDto> courseNameDtoList =new ArrayList<>();
        for(Course course:courseList){
            courseNameDto = CourseNameDto.from(course);
            courseNameDtoList.add(courseNameDto);
        }

        return courseNameDtoList;
    }

    //코스 id에 대한 코스 이름
    public CourseNameDto getCourseNameById(Long id){
        Optional<Course> course = courseRepository.findById(id);

        return course.map(CourseNameDto::from).orElse(null);
    }


    //코스 삭제
    @Transactional
    public ResponseEntity<Void> deleteCourse(Long integer){
        courseRepository.deleteById(integer);
        return null;
    }
}
