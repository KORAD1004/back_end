package com.korad1004.back_end.my_travel_plan.service;


import lombok.AllArgsConstructor;
import com.korad1004.back_end.my_travel_plan.dto.CreateRouteInfoDto;
import com.korad1004.back_end.my_travel_plan.entity.Route;
import com.korad1004.back_end.my_travel_plan.entity.Schedule;
import com.korad1004.back_end.my_travel_plan.repository.RouteRepository;
import com.korad1004.back_end.my_travel_plan.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;
    private final ScheduleRepository scheduleRepository;

    //schedule 기본키를 참조하고 dto를 통해 여행 정보 저장 및 정보 보여주
    public void createRoute(CreateRouteInfoDto createRouteInfoDto,String code){

        Route route=new Route();

        route.setCode(code);
        route.setNumber(createRouteInfoDto.getNumber());
        route.setTitle(createRouteInfoDto.getTitle());
        route.setAddress(createRouteInfoDto.getAddress());
        route.setMemo(createRouteInfoDto.getMemo());

            routeRepository.save(route);
    }

    public List<Route> getAllRouteOfCode(String code){

        return routeRepository.findByCode(code);

    }

}
