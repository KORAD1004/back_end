package com.korad1004.back_end.my_travel_plan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
public class Schedule {

    @Id
    private String code;

    //여행명
    @Column(name = "travel_name")
    private String travelName;

    //인원수
    @Column(name = "travel_headCount")
    private Integer headCount;

    //시작날짜
    @Column(name = "start_date")
    private LocalDate startDate;

    //종료날짜
    @Column(name = "end_date")
    private LocalDate endDate;

    //일차
    @Column(name = "travel_days")
    private String days;

    //여러개의 투어 항목이 들어감
    @OneToMany(mappedBy = "schedule",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<TourList> tourLists;

}
