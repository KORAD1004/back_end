package com.korad1004.back_end.my_travel_spot.controller;


import lombok.AllArgsConstructor;
import com.korad1004.back_end.my_travel_spot.dto.CreateRouteInfoDto;
import com.korad1004.back_end.my_travel_spot.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/route")
@AllArgsConstructor
public class RouteController {

    private final RouteService routeService;

    //관광지 등록 postmapping
    @PostMapping("/{schedule_id}")
    public ResponseEntity<Void> createRoute(@RequestBody CreateRouteInfoDto createRouteInfoDto, @PathVariable(name="schedule_id") Long id){

        routeService.createRoute(createRouteInfoDto,id);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //관광지 등록시 해당 일정에 대한 등록된 일정 전부 보여주는 getmapping

    //해당 코드에 관련된 동선 (근데 이게 객체 단위로 줘야할지 전부 한번에 줘도 될지)



}
