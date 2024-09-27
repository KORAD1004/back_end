package com.korad1004.back_end.category.repository;
import com.korad1004.back_end.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    //카테고리를 통해 찾기
    Optional<Category> findByCategoryName(String categoryName);

}
