package com.korad1004.back_end.my_travel_plan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //후보키: 각 여행 일정에 대한 코드
    @Column(name="travel_code",unique = true)
    private String code;

    //여행명
    @Column(name = "travel_name")
    private String travelName;

    //인원수
    @Column(name = "travel_headCount")
    private Integer headCount;

    //시작날짜
    @Column(name = "start_date")
    private LocalDateTime startDate;

    //종료날짜
    @Column(name = "end_date")
    private LocalDateTime endDate;

    //일차
    @Column(name = "travel_days")
    private Integer days;

    //해당 코스가 만들어진 시간
    @Column(name="travel_localdatetime")
    private LocalDateTime createDate;

//    //여러가지 동선 리스트
//    @OneToMany(mappedBy = "schedule")
//    private List<Route> routeList;

}
