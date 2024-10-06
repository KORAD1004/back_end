package com.korad1004.back_end.my_travel_plan.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//하나의 객체
public class GetSpotInfoOfMyTravel {

    private Integer number;

    private String memo;

    private String image;

    private String title;

    private String address;

    private String latitude;

    private String longitude;

}
