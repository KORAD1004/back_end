package com.korad1004.back_end.my_travel_plan.repository;

import com.korad1004.back_end.my_travel_plan.entity.Schedule;
import com.korad1004.back_end.my_travel_plan.entity.TourList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourListRepository extends JpaRepository<TourList,Long> {

    void deleteAllByScheduleCode(String schedule_code);
}
