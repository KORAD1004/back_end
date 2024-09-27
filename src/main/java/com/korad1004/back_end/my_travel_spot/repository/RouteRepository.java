package com.korad1004.back_end.my_travel_spot.repository;


import com.korad1004.back_end.my_travel_spot.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {
}
