package com.korad1004.back_end.scrap.controller;

import com.korad1004.back_end.scrap.dto.NationWideRadiationAverageDto;
import com.korad1004.back_end.scrap.service.ScrapService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "scrap-controller")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/scrap/radiation")
public class RadiationScrapController {

    private final ScrapService scrapService;

    @Value("${lambda.api.radiation.average}")
    private String apiUrl;

    @GetMapping("/average")
    public ResponseEntity<?> getRadiationAverage() {

        String url = apiUrl;

        return scrapService.getScrapResponse(url, NationWideRadiationAverageDto.class);
    }
}
