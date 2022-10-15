package com.example.demo.area;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-16T00:56:49+1100",
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

    @Override
    public List<AreaPostcodeResponse> toAreaPostcodeResponses(List<Area> areas) {
        if ( areas == null ) {
            return null;
        }

        List<AreaPostcodeResponse> list = new ArrayList<AreaPostcodeResponse>( areas.size() );
        for ( Area area : areas ) {
            list.add( toAreaPostcodeResponse( area ) );
        }

        return list;
    }

    @Override
    public AreaPostcodeResponse toAreaPostcodeResponse(Area area) {
        if ( area == null ) {
            return null;
        }

        AreaPostcodeResponse areaPostcodeResponse = new AreaPostcodeResponse();

        areaPostcodeResponse.setPostcode( area.getPostcode() );

        return areaPostcodeResponse;
    }

    @Override
    public Area toArea(CreateAreaRequest createAreaRequest) {
        if ( createAreaRequest == null ) {
            return null;
        }

        Area area = new Area();

        area.setPostcode( createAreaRequest.getPostcode() );
        area.setSuburb( createAreaRequest.getSuburb() );

        return area;
    }
}
