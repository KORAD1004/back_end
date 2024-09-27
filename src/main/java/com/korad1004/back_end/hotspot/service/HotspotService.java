package com.korad1004.back_end.hotspot.service;


import lombok.Getter;
import lombok.Setter;
import com.korad1004.back_end.category.entity.Category;
import com.korad1004.back_end.category.repository.CategoryRepository;
import com.korad1004.back_end.hotspot.dto.HotspotInfoDto;
import com.korad1004.back_end.hotspot.entity.Hotspot;
import com.korad1004.back_end.hotspot.repository.HotspotRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
public class HotspotService {

    private final HotspotRepository hotspotRepository;
    private final CategoryRepository categoryRepository;

    public HotspotService(HotspotRepository hotspotRepository, CategoryRepository categoryRepository){
        this.hotspotRepository = hotspotRepository;
        this.categoryRepository = categoryRepository;
    }

    public void createHotspotInfo(HotspotInfoDto hotspotInfoDto,String category){

        Hotspot hotspot=new Hotspot();

        //categoryRepo Category table 조회
        Optional<Category> categoryName= categoryRepository.findByCategoryName(category);

        hotspot.setTitle(hotspotInfoDto.getTitle());

        hotspot.setAddress(hotspotInfoDto.getAddress());

        hotspot.setHours(hotspotInfoDto.getHours());

        hotspot.setPhone_num(hotspotInfoDto.getPhone_num());

        hotspot.setSpotUrl(hotspotInfoDto.getSpotUrl());

        if(categoryName.isPresent()){
            hotspot.setCategory(categoryName.get());
        }
        hotspotRepository.save(hotspot);
    }

    public List<HotspotInfoDto> getHotspotList(String category){

        List<HotspotInfoDto> hotspotInfoDtoList =new ArrayList<>();

        //해당 카테고리를 카테고리 데이터베이스에서 조사
        Optional<Category> optionalCategory=categoryRepository.findByCategoryName(category);

        //카테고리 존재시
        if(optionalCategory.isPresent()){

            HotspotInfoDto hotspotInfoDto;

            //해당 카테고리로 저장되어 있는 spot을 모두 불러옴
            Optional<List<Hotspot>> optionalHotspots=hotspotRepository.findAllByCategory(optionalCategory.get());


            if(optionalHotspots.isPresent()){

                List<Hotspot> hotspotList=optionalHotspots.get();

                for(Hotspot hotspot:hotspotList){
                    hotspotInfoDto = HotspotInfoDto.from(hotspot);
                    hotspotInfoDtoList.add(hotspotInfoDto);
                }

                return hotspotInfoDtoList;
            }

        }


        return null;
    }

}
