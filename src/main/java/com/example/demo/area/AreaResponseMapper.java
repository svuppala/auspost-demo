package com.example.demo.area;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AreaResponseMapper {

    List<AreaSuburbResponse> toAreaSuburbResponses(List<Area> areas);

    AreaSuburbResponse toAreaSuburbResponse(Area area);

    List<AreaPostcodeResponse> toAreaPostcodeResponses(List<Area> areas);

    AreaPostcodeResponse toAreaPostcodeResponse(Area area);

    Area toArea(CreateAreaRequest createAreaRequest);
}
