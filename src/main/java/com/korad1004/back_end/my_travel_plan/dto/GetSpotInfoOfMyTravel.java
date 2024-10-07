package com.korad1004.back_end.my_travel_plan.dto;

import com.korad1004.back_end.my_travel_plan.entity.TourList;
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

    private String spotURL;

    public static GetSpotInfoOfMyTravel from(TourList tourList){
        GetSpotInfoOfMyTravel getSpotInfoOfMyTravel = new GetSpotInfoOfMyTravel();
        getSpotInfoOfMyTravel.setNumber(tourList.getNumber());
        getSpotInfoOfMyTravel.setMemo(tourList.getMemo());
        getSpotInfoOfMyTravel.setImage(tourList.getHotspot().getImage());
        getSpotInfoOfMyTravel.setTitle(tourList.getHotspot().getTitle());
        getSpotInfoOfMyTravel.setAddress(tourList.getHotspot().getAddress());
        getSpotInfoOfMyTravel.setLatitude(tourList.getHotspot().getLatitude());
        getSpotInfoOfMyTravel.setLongitude(tourList.getHotspot().getLongitude());
        getSpotInfoOfMyTravel.setSpotURL(tourList.getHotspot().getSpotURL());

        return getSpotInfoOfMyTravel;
    }

}
