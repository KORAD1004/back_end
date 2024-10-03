package com.korad1004.back_end.scrap.dto;

import lombok.Data;

@Data
public class KoradNaverBlogRecentArticleDto {

    private int idx;
    private Content content;

    @Data
    public static class Content {
        private String notice_num;
        private String title;
        private String content;
        private String write_date;
        private String url;
    }
}
