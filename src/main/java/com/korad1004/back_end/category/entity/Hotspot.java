package com.korad1004.back_end.category.entity;


import com.korad1004.back_end.course.entity.CoursePlace;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Hotspot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //장소 이름
    @Column
    private String title;

    //장소 이미지
    @Column
    private String image;

    //장소 주소
    @Column
    private String address;

    //장소 전화번호
    @Column
    private String phone_num;

    //위도
    @Column
    private String latitude;

    //경도
    @Column
    private String longitude;

    //장소 URL (도메인 주소)
    @Column
    private String subTitle;

    //카테고리 별 장소 지정
    @ManyToOne
    @JoinColumn(name="category_category_name")
    private Category category;

    @OneToMany(mappedBy = "hotspot")
    private List<CoursePlace> coursePlaceList;
}
