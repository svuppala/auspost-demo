package com.example.demo.area;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/area")
public class AreaController {

    private final AreaService areaService;

    private final AreaResponseMapper areaResponseMapper;

    @GetMapping(path = "/suburb/{postcode}")
    public List<AreaSuburbResponse> getSuburbs(@PathVariable("postcode") int postcode){
        return areaResponseMapper.toAreaSuburbResponses(areaService.getAreasByPostCode(postcode));

    }
}
