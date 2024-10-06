package com.korad1004.back_end.my_travel_plan.repository;

import com.korad1004.back_end.my_travel_plan.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,String> {

    Optional<Schedule> findByCode(String code);

}
