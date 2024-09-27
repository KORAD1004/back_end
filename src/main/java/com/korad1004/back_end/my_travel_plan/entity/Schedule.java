package com.korad1004.back_end.my_travel_plan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import com.korad1004.back_end.my_travel_spot.entity.Route;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="travel_code")
    private String code;

    @Column(name = "travel_name")
    private String travelName;

    @Column(name = "travel_headCount")
    private Integer headCount;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "travel_days")
    private Integer days;

    @Column(name="travel_localdatetime")
    private LocalDateTime createDate;

    @OneToMany(mappedBy = "schedule")
    private List<Route> routeList;
}
