package com.korad1004.back_end.category.dto;

import com.korad1004.back_end.category.entity.Hotspot;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(description = "모든 Hotspot 정보 불러 오는 객체")
public class GetAllHotspotInfo {

    @Schema(description = "저장된 핫스팟 아이디",example = "1")
    private Long id;
    @Schema(description = "저장된 핫스팟 제목",example = "국립경주문화재연구소 천존고")
    private String title;
    @Schema(description = "저장된 장소 주소",example = "경상북도 경주시 불국로 132 (마동)")
    private String address;

    public static GetAllHotspotInfo from(Hotspot hotspot){
        GetAllHotspotInfo getAllHotspotInfo = new GetAllHotspotInfo();

        getAllHotspotInfo.setId(hotspot.getId());
        getAllHotspotInfo.setTitle(hotspot.getTitle());
        getAllHotspotInfo.setAddress(hotspot.getAddress());

        return getAllHotspotInfo;
    }

}
