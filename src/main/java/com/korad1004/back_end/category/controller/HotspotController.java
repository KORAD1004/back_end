package com.korad1004.back_end.category.controller;


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

    @PostMapping("/all-place-insert")
    public void createHotspotCategory() {
        hotspotService.createHotspots();
    }

}
