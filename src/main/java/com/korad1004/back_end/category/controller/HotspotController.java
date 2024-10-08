package com.korad1004.back_end.category.controller;


import com.korad1004.back_end.category.dto.GetAllHotspotInfo;
import com.korad1004.back_end.category.dto.GetAllSpotOfString;
import com.korad1004.back_end.category.dto.HotspotInfoDto;
import com.korad1004.back_end.category.service.HotspotService;
import org.springframework.http.HttpStatus;
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
public class HotspotController {

    private final HotspotService hotspotService;

    public HotspotController(HotspotService hotspotService){
        this.hotspotService=hotspotService;
    }

    //각 카테고리별 장소 정보 등록
    @PostMapping("/{category}")
    public ResponseEntity<Void> createHotspot(@RequestBody HotspotInfoDto hotspotInfoDto, @PathVariable(name="category") String category){

        hotspotService.createHotspotInfo(hotspotInfoDto,category);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //카테고리 요청시 해당 되는 카테고리 장소 전부 리스트업
    @GetMapping("/{category}")
    public ResponseEntity<List<HotspotInfoDto>> getHotspotOfCategory(@PathVariable(name="category") String category) {

        hotspotService.getHotspotList(category);

        if (hotspotService.getHotspotList(category) != null) {
            return ResponseEntity.ok(hotspotService.getHotspotList(category));  //따로
        }

        return ResponseEntity.notFound().build();
    }

    //무한 GET요청 모든 HOTSPOT 넘겨주기
    @GetMapping
    public ResponseEntity<List<GetAllHotspotInfo>> getAllHotspot(){

        return ResponseEntity.ok(hotspotService.getAllHotspot());

    }

    //CSV 데이터 넣기
    @PostMapping("/all-place-insert")
    public ResponseEntity<Void> createHotspotCategory() {
        hotspotService.createHotspots();

        return ResponseEntity.created(URI.create("/all-place-insert")).build();
    }

    @GetMapping(value = {"/search/", "/search/{string}"})
    public ResponseEntity<List<GetAllSpotOfString>> getAllSpotOfString(@PathVariable(required = false) String string){

        if (string == null) {
            return ResponseEntity.ok(new ArrayList<>());
        }

        return ResponseEntity.ok(hotspotService.getAllSpotOfString(string));
    }


}
