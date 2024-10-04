package com.korad1004.back_end.scrap.controller;

import com.korad1004.back_end.scrap.dto.NationWideRadiationAverageDto;
import com.korad1004.back_end.scrap.service.ScrapService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "scrap-controller")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/scrap/radiation")
public class RadiationScrapController {

    private final ScrapService scrapService;

    @Value("${lambda.api.radiation.average}")
    private String apiUrlAverage;

    @Value("${lambda.api.radiation.recent.average}")
    private String apiUrlRecentAverage;

    @GetMapping("/average")
    public ResponseEntity<?> getRadiationAverage() {

        String url = apiUrlAverage;

        return scrapService.getScrapResponse(url, NationWideRadiationAverageDto.class);
    }

    @GetMapping("/recent/{type}")
    public ResponseEntity<?> getRecentRadiationAverage(@PathVariable String type) {

        String url = apiUrlRecentAverage;

        if (type == null) {
            type = "avg";
        }

        if (type.equals("avg")) {
            url = url + "?type=avg";
        }
        else if (type.equals("all")) {
            url = url + "?type=all";
        }
        else {
            return ResponseEntity.badRequest().body("잘못된 요청입니다. {type}");
        }

        return scrapService.getScrapResponse(url, NationWideRadiationAverageDto.class);
    }
}
