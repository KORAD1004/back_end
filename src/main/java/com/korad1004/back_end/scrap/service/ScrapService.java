package com.korad1004.back_end.scrap.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScrapService {
    private final RestClient restClient;

    public <T> ResponseEntity<?> getScrapResponse(String url, Class<T> dto) {
        try {
            ResponseEntity<List<T>> responseEntity = restClient.get()
                    .uri(url)
                    .retrieve()
                    .toEntity(new ParameterizedTypeReference<>() {});


            if (!responseEntity.getStatusCode().is2xxSuccessful()) {
                return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
            }

            List<?> data = responseEntity.getBody();
            if (data == null || data.isEmpty()) {
                log.error("Response 에러: {}", data);
                return ResponseEntity.internalServerError().body("스크랩 API 서버의 요청에 문제가 발생하였습니다.");
            }

            return ResponseEntity.ok(data);
        } catch (Exception e) {
            log.error("getScrapResponse 에러 : {}", e.getMessage());
            return ResponseEntity.status(500).body("스크랩 API 서버와의 통신에 실패하였습니다.");
        }
    }
}
