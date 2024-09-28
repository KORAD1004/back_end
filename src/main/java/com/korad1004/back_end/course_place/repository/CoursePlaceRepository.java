package com.korad1004.back_end.course_place.repository;

import com.korad1004.back_end.course.entity.Course;
import com.korad1004.back_end.course_place.entity.CoursePlace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursePlaceRepository extends JpaRepository<CoursePlace,Long> {

    List<CoursePlace> findByCourse(Course course);
}
