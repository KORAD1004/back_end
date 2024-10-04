package com.korad1004.back_end.my_travel_plan.controller;


import com.korad1004.back_end.my_travel_plan.entity.Route;
import lombok.AllArgsConstructor;
import com.korad1004.back_end.my_travel_plan.dto.CreateRouteInfoDto;
import com.korad1004.back_end.my_travel_plan.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/route")
@AllArgsConstructor
public class RouteController {

    private final RouteService routeService;

    //관광지 등록 postmapping
    @PostMapping("/search/{code}")
    public ResponseEntity<Void> createRoute(@RequestBody CreateRouteInfoDto createRouteInfoDto, @PathVariable(name="code") String code){

        routeService.createRoute(createRouteInfoDto,code);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{code}")
    public ResponseEntity<List<Route>> getAllRouteOfCode(@PathVariable(name="code") String code){

        return ResponseEntity.ok(routeService.getAllRouteOfCode(code));

    }



    //관광지 등록시 해당 일정에 대한 등록된 일정 전부 보여주는 getmapping

    //해당 코드에 관련된 동선 (근데 이게 객체 단위로 줘야할지 전부 한번에 줘도 될지)



}
