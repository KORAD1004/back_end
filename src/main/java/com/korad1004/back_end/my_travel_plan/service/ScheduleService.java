package com.korad1004.back_end.my_travel_plan.service;

import com.korad1004.back_end.category.repository.HotspotRepository;
import com.korad1004.back_end.my_travel_plan.dto.CreateCourseDto;
import com.korad1004.back_end.my_travel_plan.dto.TourListDto;
import com.korad1004.back_end.my_travel_plan.entity.Schedule;
import com.korad1004.back_end.my_travel_plan.entity.TourList;
import com.korad1004.back_end.my_travel_plan.repository.ScheduleRepository;
import com.korad1004.back_end.my_travel_plan.repository.TourListRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.time.LocalDateTime;


@RestController
@RequestMapping("/api/schedule_test")
@AllArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final TourListRepository tourListRepository;
    private final HotspotRepository hotspotRepository;
    private final LocalDateTimeNumericEncryption localDateTimeNumericEncryption;


    //스케줄 만들기
    public void createSchedule(CreateCourseDto createCourseDto) throws Exception {
        Schedule schedule = new Schedule();
        StringBuilder numericEncryptedDateTime;
        while(true){
                SecretKey secretKey = KeyGenerator.getInstance(localDateTimeNumericEncryption.getALGORITHM()).generateKey();
                LocalDateTime code = LocalDateTime.now();
                numericEncryptedDateTime = new StringBuilder("#").append(localDateTimeNumericEncryption.encryptToSixDigits(code, secretKey));

                if(scheduleRepository.findByCode(String.valueOf(numericEncryptedDateTime)).isEmpty())
                    break;
        }
        //localtime 암호화
        schedule.setCode(numericEncryptedDateTime.toString());

        //여행 이름
        schedule.setTravelName(createCourseDto.getTravelName());

        //인원수
        schedule.setHeadCount(createCourseDto.getHeadCount());

        //시작날짜
        schedule.setStartDate(createCourseDto.getStartDate());

        //종료 날짜
        schedule.setEndDate(createCourseDto.getEndDate());

        //일수
        schedule.setDays(createCourseDto.getDays());

        //먼저 저장
        scheduleRepository.save(schedule);

        for(TourListDto tourListDto:createCourseDto.getTourListDtoList()){
            TourList tourList=new TourList();
            tourList.setNumber(tourListDto.getNumber());

            //Integer로 받고 hotspot객체를 찾아 저장
            if(hotspotRepository.findById(tourListDto.getHotspot()).isPresent())
                tourList.setHotspot(hotspotRepository.findById(tourListDto.getHotspot()).get());

            //메모 저장
            tourList.setMemo(tourListDto.getMemo());

            //해당 스케줄 id 받아오기
            if(scheduleRepository.findByCode(schedule.getCode()).isPresent())
                tourList.setSchedule(scheduleRepository.findByCode(schedule.getCode()).get());

            tourListRepository.save(tourList);
        }

    }
}
