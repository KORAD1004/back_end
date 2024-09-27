package com.korad1004.back_end.my_travel_spot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import com.korad1004.back_end.my_travel_plan.entity.Schedule;

@Entity
@Getter
@Setter
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "route_id")
    private Long id;

    @Column(name="route_number")
    private Integer number;


    @Column(name="spot_info")
    private String address; //장소 주소


    @Column(name="spot_hours")
    private String hours;  //영업시간


    @Column(name="spot_url")
    private String spotUrl;  //장소 홈페이지 주소


    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;


}
