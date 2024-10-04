package com.korad1004.back_end.my_travel_plan.repository;


import com.korad1004.back_end.my_travel_plan.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {

    List<Route> findByCode(String code);

}
