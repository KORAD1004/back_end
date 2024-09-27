package com.korad1004.back_end.hotspot.dto;

import lombok.Getter;
import lombok.Setter;
import com.korad1004.back_end.hotspot.entity.Hotspot;

@Getter
@Setter
//제목, 주소, 영업시간, 장소 번호, 도메인주소 등록 dto
public class HotspotInfoDto {

    private String title;

    private String address;

    private String hours;

    private String phone_num;

    private String spotUrl;

    public static HotspotInfoDto from(Hotspot hotspot){
        HotspotInfoDto hotspotInfoDto = new HotspotInfoDto();
        hotspotInfoDto.setTitle(hotspot.getTitle());
        hotspotInfoDto.setAddress(hotspot.getAddress());
        hotspotInfoDto.setHours(hotspot.getHours());
        hotspotInfoDto.setPhone_num(hotspotInfoDto.getPhone_num());
        hotspotInfoDto.setSpotUrl(hotspotInfoDto.getSpotUrl());

        return hotspotInfoDto;
    }
}
