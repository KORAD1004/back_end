package com.korad1004.back_end.category.controller;


import com.korad1004.back_end.category.dto.GetAllHotspotInfo;
import com.korad1004.back_end.category.dto.GetAllSpotOfString;
import com.korad1004.back_end.category.dto.HotspotInfoDto;
import com.korad1004.back_end.category.entity.Hotspot;
import com.korad1004.back_end.category.service.HotspotService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/hotspot")
@Tag(name = "hotspot",description = "가볼만한 곳" + " + 나의 여행 일정 짜기 API")
public class HotspotController {

    private final HotspotService hotspotService;

    public HotspotController(HotspotService hotspotService){
        this.hotspotService=hotspotService;
    }

    //각 카테고리별 장소 정보 등록
    @PostMapping("/{category}")
    @Operation(
            summary = "<가볼만 한 곳>특정 카테고리에 대한 장소 등록",
            description = "특정 카테고리를 Path로 입력 합니다."+
                    "장소 제목, 이미지 주소, 장소 주소, 장소 번호, 서브타이틀을 받아옵니다."+
                    "특정 장소에 대한 정보를 저장합니다."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "장소 등록 성공",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = HotspotInfoDto.class)
                    )
            ),
            @ApiResponse(responseCode = "400", description = "Bad Request - 유효하지 않은 입력값 오로지 Path가 String 타입")

    })
    public ResponseEntity<Void> createHotspot(@RequestBody HotspotInfoDto hotspotInfoDto, @PathVariable(name="category") String category){

        hotspotService.createHotspotInfo(hotspotInfoDto,category);

        return ResponseEntity.created(URI.create("/api/hotspot/{category}")).build();
    }


    //카테고리 요청시 해당 되는 카테고리 장소 전부 리스트업
    @GetMapping("/{category}")
    @Operation(
            summary = "<가볼만 한 곳> 특정 카테고리에 대한 장소 리스트업",
            description = "특정 카테고리를 Path로 입력 시 "+
                    " 특정 카테고리와 관련된 모든 장소를 리스트업 해준다."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "특정 카테고리에 대한 장소 리스트업 성공",
                    content = @Content(
                            mediaType = "application.json",
                            schema = @Schema(type = "array",implementation = HotspotInfoDto.class)
                    )
            )
    })
    public ResponseEntity<List<HotspotInfoDto>> getHotspotOfCategory(@PathVariable(name="category") String category) {

        hotspotService.getHotspotList(category);

        if (hotspotService.getHotspotList(category) != null) {
            return ResponseEntity.ok(hotspotService.getHotspotList(category));  //따로
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    @Operation(
            summary = "<가볼만 한 곳> 카테고리 구분 없이 저장 되어있는 모든 장소 리스트 업",
            description = " Try it out -> execute" +
                    "데이베이스에 저장되어 있는 모든 장소를 받을 수 있다."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "모든 저장된 장소를 잘 불러옴",
                    content = @Content(
                            mediaType = "application.json",
                            schema = @Schema(type = "array",implementation = GetAllHotspotInfo.class)
                    )
            )
    })
    public ResponseEntity<List<GetAllHotspotInfo>> getAllHotspot(){

        return ResponseEntity.ok(hotspotService.getAllHotspot());

    }

    //CSV 데이터 넣기
    @Operation(
            summary = "<가볼만 한 곳> CSV에 저장된 데이터 주입",
            description = " Try it out -> execute" +
                    "CSV에 저장된 데이터를 각 카테고리 별로 알아서 저장됨."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "모든 장소 저장 완료"
            )
    })
    @PostMapping("/all-place-insert")
    public ResponseEntity<Void> createHotspotCategory() {
        hotspotService.createHotspots();

        return ResponseEntity.created(URI.create("/all-place-insert")).build();
    }


    //무한 GET요청 모든 HOTSPOT 넘겨주기
    @GetMapping(value = {"/search/", "/search/{string}"})
    @Operation(
            summary = "<나의 여행 일정 짜기> 장소 검색",
            description = " 한 글자 한 글자에 대한" +
                    " 무한 Get 요청 내림차순 되어있음"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "특정 글자에 대한 장소들 보여 주기 성공",
                    content = @Content(
                            mediaType = "application.json",
                            schema = @Schema(type = "array",implementation = GetAllSpotOfString.class)
                    )
            )
    })
    public ResponseEntity<List<GetAllSpotOfString>> getAllSpotOfString(@PathVariable(required = false) String string){

        if (string == null) {
            return ResponseEntity.ok(new ArrayList<>());
        }

        return ResponseEntity.ok(hotspotService.getAllSpotOfString(string));
    }


}
