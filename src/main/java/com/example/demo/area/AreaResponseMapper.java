package com.example.demo.area;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AreaResponseMapper {

    List<AreaSuburbResponse> toAreaSuburbResponses(List<Area> areas);

    AreaSuburbResponse toAreaSuburbResponse(Area area);
}
