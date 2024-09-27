package com.korad1004.back_end.hotspot.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import com.korad1004.back_end.category.entity.Category;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Hotspot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //장소 이미지
    @Column(name="hotspot_image")
    private String image;

    //장소 이름
    @Column
    private String title;

    //장소 주소
    @Column
    private String address;

    //장소 영업시간
    @Column
    private String hours;

    //장소 전화번호
    @Column
    private String phone_num;

    //장소 URL (도메인 주소)
    @Column
    private String spotUrl;

    //데이터 삽입 시간
    @CreationTimestamp
    @Column
    private LocalDateTime localDateTime;

    //카테고리 별 장소 지정
    @ManyToOne
    @JoinColumn(name="category_category_name")
    private Category category;

}
