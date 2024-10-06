package com.korad1004.back_end.my_travel_plan.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
//Post용 Dto
public class CreateCourseDto {

    //여행명
    private String travelName;

    private Integer headCount;

    private String startDate;

    private String endDate;

    private Integer days;

    //hotspot_id, number, memo
    private List<TourListDto> tourListDtoList;

}
