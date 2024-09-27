package com.korad1004.back_end.my_travel_spot.dto;

import lombok.Getter;
import lombok.Setter;
import com.korad1004.back_end.my_travel_spot.entity.Route;

@Getter
@Setter
public class CreateRouteInfoDto {

    private Integer number;
    private String address;
    private String hours;
    private String spotUrl;

    public static CreateRouteInfoDto from(Route route){
        CreateRouteInfoDto createRouteInfoDto = new CreateRouteInfoDto();

        createRouteInfoDto.setNumber(route.getNumber());
        createRouteInfoDto.setAddress(route.getAddress());
        createRouteInfoDto.setHours(route.getHours());
        createRouteInfoDto.setSpotUrl(route.getSpotUrl());


        return createRouteInfoDto;
    }
}
