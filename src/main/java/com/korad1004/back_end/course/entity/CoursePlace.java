package com.korad1004.back_end.course.entity;

import com.korad1004.back_end.category.entity.Hotspot;
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

    @Column(name="courseplace_number")
    private Integer number;

    @Column
    private String image;

    @Column
    private String title;

    @Column
    private String address;

    @Column
    private String phone_num;

    @ManyToOne
    @JoinColumn(name = "course_course_name")
    private Course course;

    @ManyToOne
    @JoinColumn(name="hotspot_hotspot_title")
    private Hotspot hotspot;
}
