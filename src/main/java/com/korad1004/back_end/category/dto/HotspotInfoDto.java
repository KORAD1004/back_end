package com.korad1004.back_end.category.dto;

import lombok.Getter;
import lombok.Setter;
import com.korad1004.back_end.category.entity.Hotspot;

@Getter
@Setter
//제목, 주소, 영업시간, 장소 번호, 도메인주소 등록 dto
public class HotspotInfoDto {

    private String title;

    private String image;

    private String address;

    private String phone_num;

    private String subTitle;

    public static HotspotInfoDto from(Hotspot hotspot){
        HotspotInfoDto hotspotInfoDto = new HotspotInfoDto();
        hotspotInfoDto.setTitle(hotspot.getTitle());
        hotspotInfoDto.setAddress(hotspot.getAddress());
        hotspotInfoDto.setImage(hotspot.getImage());
        hotspotInfoDto.setPhone_num(hotspot.getPhone_num());
        hotspotInfoDto.setSubTitle(hotspot.getSubTitle());

        return hotspotInfoDto;
    }
}
