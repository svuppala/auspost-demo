package com.example.demo.area;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AreaResponseMapperTest {

    @InjectMocks
    private final AreaResponseMapper areaResponseMapper = Mappers.getMapper(AreaResponseMapper.class);
    private static final Integer POSTCODE = 3168;
    private static final String SUBURB = "Clayton";

    @Test
    void toAreaSuburbResponses_withValidValues() {
        //given
        List<AreaSuburbResponse> expectedAreaSuburbResponses = getAreaSuburbResponses();

        //when
        List<AreaSuburbResponse> actualAreaSuburbResponses = areaResponseMapper.toAreaSuburbResponses(getAreaList());

        //then
        assertThat(expectedAreaSuburbResponses.size(), is(actualAreaSuburbResponses.size()));
        assertThat(expectedAreaSuburbResponses.get(0).getSuburb(), is(actualAreaSuburbResponses.get(0).getSuburb()));
    }

    @Test
    void toAreaSuburbResponse_withValidValues() {
        //given
        AreaSuburbResponse expectedAreaSuburbResponse = getAreaSuburbResponse();

        //when
        AreaSuburbResponse actualAreaSuburbResponse = areaResponseMapper.toAreaSuburbResponse(getArea());

        //then
        assertThat(expectedAreaSuburbResponse.getSuburb(), is(actualAreaSuburbResponse.getSuburb()));
    }

    @Test
    void toAreaPostcodeResponses_withValidValues() {
        //given
        List<AreaPostcodeResponse> expectedAreaPostcodeResponses = getAreaPostcodeResponses();

        //when
        List<AreaPostcodeResponse> actualAreaPostcodeResponses = areaResponseMapper.toAreaPostcodeResponses(getAreaList());

        //then
        assertThat(expectedAreaPostcodeResponses.size(), is(actualAreaPostcodeResponses.size()));
        assertThat(expectedAreaPostcodeResponses.get(0).getPostcode(), is(actualAreaPostcodeResponses.get(0).getPostcode()));
    }

    @Test
    void toAreaPostcodeResponse_withValidValues() {
        //given
        AreaPostcodeResponse expectedAreaPostcodeResponse = getAreaPostcodeResponse();

        //when
        AreaPostcodeResponse actualAreaPostcodeResponse = areaResponseMapper.toAreaPostcodeResponse(getArea());

        //then
        assertThat(expectedAreaPostcodeResponse.getPostcode(), is(actualAreaPostcodeResponse.getPostcode()));
    }

    @Test
    void toArea_withValidValues() {
        //given
        Area expectedArea = getArea();

        //when
        Area actualArea = areaResponseMapper.toArea(getCreateAreaRequest());

        //then
        assertThat(expectedArea.getSuburb(), is(actualArea.getSuburb()));
        assertThat(expectedArea.getPostcode(), is(actualArea.getPostcode()));
    }


    private Area getArea() {
        return Area.builder()
                .postcode(POSTCODE)
                .suburb(SUBURB)
                .build();
    }

    private List<Area> getAreaList() {
        return asList(getArea());
    }

    private CreateAreaRequest getCreateAreaRequest() {
        return CreateAreaRequest.builder()
                .postcode(POSTCODE)
                .suburb(SUBURB)
                .build();
    }

    private AreaSuburbResponse getAreaSuburbResponse() {
        return AreaSuburbResponse.builder()
                .suburb(SUBURB)
                .build();
    }

    private List<AreaSuburbResponse> getAreaSuburbResponses() {
        return asList(getAreaSuburbResponse());
    }

    private AreaPostcodeResponse getAreaPostcodeResponse() {
        return AreaPostcodeResponse.builder()
                .postcode(POSTCODE)
                .build();
    }

    private List<AreaPostcodeResponse> getAreaPostcodeResponses() {
        return asList(getAreaPostcodeResponse());
    }

}