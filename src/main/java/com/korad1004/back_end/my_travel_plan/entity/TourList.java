package com.korad1004.back_end.my_travel_plan.entity;

import com.korad1004.back_end.category.entity.Hotspot;
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
public class TourList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;

    @ManyToOne
    @JoinColumn(name="hotspot_id")
    private Hotspot hotspot;

    private String memo;

    @ManyToOne
    @JoinColumn(name = "schedule_code")
    private Schedule schedule;



}
