package com.korad1004.back_end.category.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import com.korad1004.back_end.category.dto.CategoryNameDto;
import com.korad1004.back_end.category.entity.Category;
import com.korad1004.back_end.category.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;

@RestController
@RequestMapping("api/category")
@AllArgsConstructor
@Tag(name="category",description = "가볼만한 곳 카테고리 항목 저장 API")
public class CategoryController {

    private final CategoryService categoryService;
    //카테고리 이름 등록
    @PostMapping
    @Operation(
            summary = "<가볼만 한 곳> 카테 고리 항목 저장",
            description = " 역사적, 나홀로, 정적인, 상징적, 활동적, 아이들"+
                    " 등과 같은 카테고리 저장이 가능한 엔드 포인트"
    )
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "201",
                    description = "카테고리 저장 성공",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CategoryNameDto.class))
                            //특정 Dto를 Responses에 실어준다.
                    )
            )
    })
    public ResponseEntity<Category> createCategory(@RequestBody CategoryNameDto categoryNameDto){

        categoryService.createCategory(categoryNameDto);

        return ResponseEntity.created(URI.create("api/category")).build();
    }

}
