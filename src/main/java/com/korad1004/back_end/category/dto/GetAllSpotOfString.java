package com.korad1004.back_end.category.dto;

import com.korad1004.back_end.category.entity.Hotspot;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "나의 여행 일정 짜기 글자 검색 시 장소 리스트 업")
public class GetAllSpotOfString {
        private Long id;

        @Schema(description = "장소 제목",example = "경주 코라드 공원")
        private String title;

        @Schema(description = "장소 주소", example = "경주 문화 공원 34길")
        private String address;

        @Schema(description = "장소 위도",example = "34.5542321")
        private String latitude;

        @Schema(description = "장소 경도",example = "73.4142432")
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
