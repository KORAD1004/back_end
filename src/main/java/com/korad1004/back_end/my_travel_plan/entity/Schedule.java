package com.korad1004.back_end.my_travel_plan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
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
    private String startDate;

    //종료날짜
    @Column(name = "end_date")
    private String endDate;

    //일차
    @Column(name = "travel_days")
    private String days;

    @OneToMany(mappedBy = "schedule",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<TourList> tourLists;

}
