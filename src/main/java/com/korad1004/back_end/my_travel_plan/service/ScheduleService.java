package com.korad1004.back_end.my_travel_plan.service;

import com.korad1004.back_end.category.repository.HotspotRepository;
import com.korad1004.back_end.my_travel_plan.dto.CreateCourseDto;
import com.korad1004.back_end.my_travel_plan.dto.GetScheduleOfCode;
import com.korad1004.back_end.my_travel_plan.dto.GetSpotInfoOfMyTravel;
import com.korad1004.back_end.my_travel_plan.dto.TourListDto;
import com.korad1004.back_end.my_travel_plan.entity.Schedule;
import com.korad1004.back_end.my_travel_plan.entity.TourList;
import com.korad1004.back_end.my_travel_plan.repository.ScheduleRepository;
import com.korad1004.back_end.my_travel_plan.repository.TourListRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Getter
@Setter
@AllArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final TourListRepository tourListRepository;
    private final HotspotRepository hotspotRepository;
    private final LocalDateTimeNumericEncryption localDateTimeNumericEncryption;


    //스케줄 만들기
    public String createSchedule(CreateCourseDto createCourseDto) throws Exception {
        Schedule schedule = new Schedule();
        StringBuilder numericEncryptedDateTime;
        while(true){
                SecretKey secretKey = KeyGenerator.getInstance(localDateTimeNumericEncryption.getALGORITHM()).generateKey();
                LocalDateTime code = LocalDateTime.now();
                numericEncryptedDateTime = new StringBuilder(localDateTimeNumericEncryption.encryptToSixDigits(code, secretKey));

                if(scheduleRepository.findByCode(String.valueOf(numericEncryptedDateTime)).isEmpty())
                    break;
        }
        //localtime 암호화
        schedule.setCode(numericEncryptedDateTime.toString());

        //여행 이름
        schedule.setTravelName(createCourseDto.getTravelName());

        //인원수
        schedule.setHeadCount(createCourseDto.getHeadCount());


        //시작날짜가 종료날짜보다 작다 -> true 반환
        if(createCourseDto.getStartDate().isBefore(createCourseDto.getEndDate())){
            //시작날짜
            schedule.setStartDate(createCourseDto.getStartDate());

            //종료 날짜
            schedule.setEndDate(createCourseDto.getEndDate());
        }
        else if(createCourseDto.getStartDate().isEqual(createCourseDto.getEndDate())){
            //시작날짜
            schedule.setStartDate(createCourseDto.getStartDate());

            //종료 날짜
            schedule.setEndDate(createCourseDto.getEndDate());
        }
        else throw new RuntimeException("시간 잘못 입력 하셨습니다.");


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

            //해당 스케줄 code 받아오기
            if(scheduleRepository.findByCode(schedule.getCode()).isPresent())
                tourList.setSchedule(scheduleRepository.findByCode(schedule.getCode()).get());

            tourListRepository.save(tourList);
        }

        return numericEncryptedDateTime.toString();

    }

    //해당 코드에 대한 스케줄 받아오기
    public List<Object> getScheduleOfCode(String code){

        GetScheduleOfCode getScheduleOfCode;
        Optional<Schedule> optionalSchedule= scheduleRepository.findByCode(code);
        Schedule schedule;
        GetSpotInfoOfMyTravel getSpotInfoOfMyTravel;
        List<GetSpotInfoOfMyTravel> getSpotInfoOfMyTravelList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();
        if(optionalSchedule.isPresent()){
            schedule = optionalSchedule.get();

            getScheduleOfCode=GetScheduleOfCode.from(schedule);

            objectList.add(getScheduleOfCode);

            for(TourList tourList:schedule.getTourLists()){

                getSpotInfoOfMyTravel=GetSpotInfoOfMyTravel.from(tourList);

                getSpotInfoOfMyTravelList.add(getSpotInfoOfMyTravel);
            }

            objectList.add(getSpotInfoOfMyTravelList);
        }

        return objectList;
    }
}
