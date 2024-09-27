package com.korad1004.back_end.course_place.entity;

import com.korad1004.back_end.course.entity.Course;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CoursePlace {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="courseplace_id")
    private Long id;

    @Column(name="courseplace_image")
    private String image;

    @Column(name="courseplace_title")
    private String title;     //장소 이름

    @Column(name="courseplace_address")
    private String address;   //장소 주소

    @Column(name="courseplace_spoturl")
    private String spotUrl;   //장소 홈페이지 주소

    @ManyToOne
    @JoinColumn(name = "course_course_name")
    private Course course;
}
