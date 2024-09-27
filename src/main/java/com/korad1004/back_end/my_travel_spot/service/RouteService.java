package com.korad1004.back_end.my_travel_spot.service;


import lombok.AllArgsConstructor;
import com.korad1004.back_end.my_travel_plan.entity.Schedule;
import com.korad1004.back_end.my_travel_plan.repository.ScheduleRepository;
import com.korad1004.back_end.my_travel_spot.dto.CreateRouteInfoDto;
import com.korad1004.back_end.my_travel_spot.entity.Route;
import com.korad1004.back_end.my_travel_spot.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;
    private final ScheduleRepository scheduleRepository;

    //schedule 기본키를 참조하고 dto를 통해 여행 정보 저장 및 정보 보여주
    public void createRoute(CreateRouteInfoDto createRouteInfoDto,Long id){
        Optional<Schedule> optionalSchedule=scheduleRepository.findById(id);

        Route route=new Route();

        if(optionalSchedule.isPresent()){ //모두 schedule의 기본키를 가지고 있어야 함

            route.setNumber(createRouteInfoDto.getNumber());
            route.setAddress(createRouteInfoDto.getAddress());
            route.setHours(createRouteInfoDto.getHours());
            route.setSpotUrl(createRouteInfoDto.getSpotUrl());
            route.setSchedule(optionalSchedule.get());

            routeRepository.save(route);
        }
    }
}
