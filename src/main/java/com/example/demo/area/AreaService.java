package com.example.demo.area;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService {

    private final AreaRepository areaRepository;

    @Autowired
    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public List<Area> getAreasByPostCode(int postcode) {
        return areaRepository.findAreaByPostcode(postcode);
    }

    public List<Area> getAreasBySuburb(String suburb) {
        return areaRepository.findAreaBySuburb(suburb);
    }
}
