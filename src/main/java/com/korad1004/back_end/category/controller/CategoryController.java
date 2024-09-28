package com.korad1004.back_end.category.controller;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.korad1004.back_end.category.dto.CategoryNameDto;
import com.korad1004.back_end.category.entity.Category;
import com.korad1004.back_end.category.service.CategoryService;
import com.korad1004.back_end.hotspot.entity.Hotspot;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    //카테고리 이름 등록
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CategoryNameDto categoryNameDto){

        Category category=categoryService.createCategory(categoryNameDto);

        return ResponseEntity.ok(category);
    }

}
