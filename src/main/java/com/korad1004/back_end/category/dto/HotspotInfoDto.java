package com.korad1004.back_end.category.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import com.korad1004.back_end.category.entity.Hotspot;

@Getter
@Setter
@Schema(description = "특정 카테고리에 대한 장소 저장 객체")
//제목, 주소, 영업시간, 장소 번호, 도메인주소 등록 dto
public class HotspotInfoDto {

    @Schema(description = "장소 제목",example = "불국사")
    private String title;

    private String image;

    @Schema(description = "장소 주소",example = "서울특별시 양천구 ...")
    private String address;

    @Schema(description = "장소 번호",example = "094-580-743")
    private String phone_num;

    @Schema(description = "장소 소개",example = "경치가 아름다운 곳")
    private String subTitle;

    @Schema(description = "장소 페이지",example = "http://www.address.com")
    private String spotURL;

    public static HotspotInfoDto from(Hotspot hotspot){
        HotspotInfoDto hotspotInfoDto = new HotspotInfoDto();
        hotspotInfoDto.setTitle(hotspot.getTitle());
        hotspotInfoDto.setAddress(hotspot.getAddress());
        hotspotInfoDto.setImage(hotspot.getImage());
        hotspotInfoDto.setPhone_num(hotspot.getPhone_num());
        hotspotInfoDto.setSubTitle(hotspot.getSubTitle());
        hotspotInfoDto.setSpotURL(hotspot.getSpotURL());

        return hotspotInfoDto;
    }
}
