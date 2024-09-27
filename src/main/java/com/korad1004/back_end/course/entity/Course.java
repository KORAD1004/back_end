package com.korad1004.back_end.course.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import com.korad1004.back_end.course_place.entity.CoursePlace;

import java.util.List;

@Entity
@Setter
@Getter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "course_id")
    private Long id;

    @Column(name = "couse_name")
    private String courseName;

    @OneToMany(mappedBy = "course")
    private List<CoursePlace> coursePlace;

}
