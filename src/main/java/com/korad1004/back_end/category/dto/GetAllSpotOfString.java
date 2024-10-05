package com.korad1004.back_end.category.dto;

import com.korad1004.back_end.category.entity.Hotspot;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllSpotOfString {
        private Long id;
        private String title;
        private String address;
        private String latitude;
        private String longitude;

        public static GetAllSpotOfString from(Hotspot hotspot){
            GetAllSpotOfString getAllSpotOfString = new GetAllSpotOfString();

            getAllSpotOfString.setId(hotspot.getId());
            getAllSpotOfString.setTitle(hotspot.getTitle());
            getAllSpotOfString.setAddress(hotspot.getAddress());
            getAllSpotOfString.setLatitude(hotspot.getLatitude());
            getAllSpotOfString.setLongitude(hotspot.getLongitude());


            return getAllSpotOfString;
        }

}
