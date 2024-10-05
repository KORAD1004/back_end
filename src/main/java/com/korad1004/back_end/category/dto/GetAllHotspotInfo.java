package com.korad1004.back_end.category.dto;

import com.korad1004.back_end.category.entity.Hotspot;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetAllHotspotInfo {

    private Long id;
    private String title;
    private String address;

    public static GetAllHotspotInfo from(Hotspot hotspot){
        GetAllHotspotInfo getAllHotspotInfo = new GetAllHotspotInfo();

        getAllHotspotInfo.setId(hotspot.getId());
        getAllHotspotInfo.setTitle(hotspot.getTitle());
        getAllHotspotInfo.setAddress(hotspot.getAddress());

        return getAllHotspotInfo;
    }

}
