package com.korad1004.back_end.category.service;


import lombok.Getter;
import lombok.Setter;
import com.korad1004.back_end.category.dto.CategoryNameDto;
import com.korad1004.back_end.category.entity.Category;
import com.korad1004.back_end.category.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Setter
@Getter
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }


    @Transactional  //카테고리 메인 이름 생성
    public Category createCategory(CategoryNameDto categoryNameDto){
        Category category =new Category();

        category.setCategoryName(categoryNameDto.getCategoryName());

        return categoryRepository.save(category);
    }

}
