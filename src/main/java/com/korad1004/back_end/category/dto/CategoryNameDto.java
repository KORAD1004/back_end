package com.korad1004.back_end.category.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "카테고리 전송 객체")
public class CategoryNameDto {

    @Schema (description = "카테고리 이름",example = "정적인")
    private String categoryName;
}
