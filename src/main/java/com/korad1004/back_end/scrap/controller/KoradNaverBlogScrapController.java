package com.korad1004.back_end.scrap.controller;

import com.korad1004.back_end.scrap.dto.KoradNaverBlogRecentArticleDto;
import com.korad1004.back_end.scrap.service.ScrapService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "scrap-controller")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/scrap/korad-naver-blog")
@Slf4j
public class KoradNaverBlogScrapController {

    private final ScrapService scrapService;

    @Value("${lambda.api.korad-naver-blog.article.recent}")
    private String apiUrl;

    @GetMapping("/article/recent/{cnt}")
    public ResponseEntity<?> getKoradNaverBlogRecentArticle(@PathVariable Integer cnt) {
        if (cnt <= 0) {
            return ResponseEntity.badRequest().body("cnt는 0 이하의 숫자값을 가질 수 없습니다.");
        }

        String url = apiUrl + "?cnt=" + cnt;

        return scrapService.getScrapResponse(url, KoradNaverBlogRecentArticleDto.class);

    }
}
