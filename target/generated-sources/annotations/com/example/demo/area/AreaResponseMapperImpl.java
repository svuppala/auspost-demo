package com.example.demo.area;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-15T11:28:22+1100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
@Component
public class AreaResponseMapperImpl implements AreaResponseMapper {

    @Override
    public List<AreaSuburbResponse> toAreaSuburbResponses(List<Area> areas) {
        if ( areas == null ) {
            return null;
        }

        List<AreaSuburbResponse> list = new ArrayList<AreaSuburbResponse>( areas.size() );
        for ( Area area : areas ) {
            list.add( toAreaSuburbResponse( area ) );
        }

        return list;
    }

    @Override
    public AreaSuburbResponse toAreaSuburbResponse(Area area) {
        if ( area == null ) {
            return null;
        }

        AreaSuburbResponse areaSuburbResponse = new AreaSuburbResponse();

        areaSuburbResponse.setSuburb( area.getSuburb() );

        return areaSuburbResponse;
    }
}
