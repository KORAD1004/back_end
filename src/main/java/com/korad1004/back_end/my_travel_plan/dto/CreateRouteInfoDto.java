package com.korad1004.back_end.my_travel_plan.dto;

import lombok.Getter;
import lombok.Setter;
import com.korad1004.back_end.my_travel_plan.entity.Route;

@Getter
@Setter
public class CreateRouteInfoDto {

    private Integer number;
    private String title;
    private String address;
    private String memo;

    public static CreateRouteInfoDto from(Route route){
        CreateRouteInfoDto createRouteInfoDto = new CreateRouteInfoDto();

        createRouteInfoDto.setNumber(route.getNumber());
        createRouteInfoDto.setTitle(route.getTitle());
        createRouteInfoDto.setAddress(route.getAddress());
        createRouteInfoDto.setMemo(route.getMemo());


        return createRouteInfoDto;
    }
}
