package com.korad1004.back_end.category.repository;

import com.korad1004.back_end.category.entity.Category;
import com.korad1004.back_end.category.entity.Hotspot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotspotRepository extends JpaRepository<Hotspot,Long> {

    Optional<List<Hotspot>> findAllByCategory(Category category);

    @Query("SELECT h FROM Hotspot h WHERE h.title LIKE CONCAT('%', :string, '%')")
    List<Hotspot> findByTitle(@Param("string") String string);
}
