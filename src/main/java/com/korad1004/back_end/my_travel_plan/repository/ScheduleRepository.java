package com.korad1004.back_end.my_travel_plan.repository;

import com.korad1004.back_end.my_travel_plan.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

    Schedule findByCode(String code);

}
