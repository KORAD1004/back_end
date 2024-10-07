package com.korad1004.back_end.category.service;


import com.korad1004.back_end.category.dto.GetAllHotspotInfo;
import com.korad1004.back_end.category.dto.GetAllSpotOfString;
import com.opencsv.CSVReader;
import lombok.Getter;
import lombok.Setter;
import com.korad1004.back_end.category.dto.HotspotInfoDto;
import com.korad1004.back_end.category.entity.Category;
import com.korad1004.back_end.category.entity.Hotspot;
import com.korad1004.back_end.category.repository.CategoryRepository;
import com.korad1004.back_end.category.repository.HotspotRepository;
import org.springframework.stereotype.Service;

import java.io.FileReader;
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

    //가볼 만한 곳 넣기
    public void createHotspotInfo(HotspotInfoDto hotspotInfoDto,String category){

        Hotspot hotspot=new Hotspot();

        //categoryRepo Category table 조회
        Optional<Category> categoryName= categoryRepository.findByCategoryName(category);

        hotspot.setTitle(hotspotInfoDto.getTitle());

        hotspot.setAddress(hotspotInfoDto.getAddress());

        hotspot.setPhone_num(hotspotInfoDto.getPhone_num());

        hotspot.setSubTitle(hotspotInfoDto.getSubTitle());

        categoryName.ifPresent(hotspot::setCategory);
        hotspotRepository.save(hotspot);
    }

    //csv 데이터 넣기 (가볼만한 곳)
    public void createHotspots(){

        try(CSVReader reader = new CSVReader(new FileReader("/home/ubuntu/nuclear_server/data.csv"))){
            reader.readNext();
            String[] arr;
            while((arr=reader.readNext())!=null){
                Hotspot hotspot = new Hotspot();
                Optional<Category> optionalCategory=categoryRepository.findByCategoryName(arr[0]);
                    hotspot.setTitle(arr[1]);
                    hotspot.setImage(arr[2]);
                    hotspot.setAddress(arr[3]);
                    hotspot.setPhone_num(arr[4]);
                    hotspot.setLatitude(arr[5]);
                    hotspot.setLongitude(arr[6]);
                    hotspot.setSubTitle(arr[7]);
                    hotspot.setSpotURL(arr[8]);
                    optionalCategory.ifPresent(hotspot::setCategory);
                    hotspotRepository.save(hotspot);
            }
        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }

    //원하는 카테고리에 대한 정보 리스트업
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

    //모든 장소 리스트업
    public List<GetAllHotspotInfo> getAllHotspot(){

        List<Hotspot> hotspotList =hotspotRepository.findAll();
        List<GetAllHotspotInfo> getAllHotspotInfoList = new ArrayList<>();

        for(Hotspot hotspot:hotspotList){
            GetAllHotspotInfo getAllHotspotInfo = new GetAllHotspotInfo();
            getAllHotspotInfo.setId(hotspot.getId());
            getAllHotspotInfo.setTitle(hotspot.getTitle());
            getAllHotspotInfo.setAddress(hotspot.getAddress());
            getAllHotspotInfoList.add(getAllHotspotInfo);
        }

        return getAllHotspotInfoList;
    }

    //나의 일정 짜기 검색시 해당 hotspot get
    public List<GetAllSpotOfString> getAllSpotOfString(String string){
        GetAllSpotOfString getAllSpotOfString;
        List<GetAllSpotOfString> getAllSpotOfStringList = new ArrayList<>();
        List<Hotspot> hotspotList= hotspotRepository.findByTitle(string);
        for(Hotspot hotspot:hotspotList){
            getAllSpotOfString = GetAllSpotOfString.from(hotspot);
            getAllSpotOfStringList.add(getAllSpotOfString);
        }
        return getAllSpotOfStringList;
    }

}
