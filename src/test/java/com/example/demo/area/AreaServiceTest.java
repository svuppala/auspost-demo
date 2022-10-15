package com.example.demo.area;

import com.example.demo.exceptions.PostCodeNotFoundException;
import com.example.demo.exceptions.ResourceAlreadyExistsException;
import com.example.demo.exceptions.SuburbNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AreaServiceTest {

    @Mock
    private AreaRepository areaRepository;
    private AreaService areaService;

    private static final Integer POSTCODE = 3168;
    private static final String SUBURB = "Clayton";

    @BeforeEach
    void setUp() {
        areaService = new AreaService(areaRepository);
    }

    @Test
    void canGetAreasByPostCode() throws PostCodeNotFoundException {
        //when
        when(areaRepository.findAreaByPostcode(POSTCODE)).thenReturn(getAreaList());
        areaService.getAreasByPostCode(POSTCODE);

        //then
        verify(areaRepository).findAreaByPostcode(POSTCODE);
    }

    @Test
    void cannotGetAreasByPostCode() throws PostCodeNotFoundException {
        //when
        when(areaRepository.findAreaByPostcode(POSTCODE)).thenReturn(new ArrayList<>());
        String expectedExceptionMessage = String.format("The provided postcode (%d) could not be found.", POSTCODE);

        Exception exception = assertThrows(PostCodeNotFoundException.class, () -> {

            areaService.getAreasByPostCode(POSTCODE);
        });
        String actualExceptionMessage = exception.getMessage();

        //then
        verify(areaRepository).findAreaByPostcode(POSTCODE);
        assertTrue(actualExceptionMessage.contains(expectedExceptionMessage));
    }

    @Test
    void canGetAreasBySuburb() throws SuburbNotFoundException {
        //when
        when(areaRepository.findAreaBySuburb(SUBURB)).thenReturn(getAreaList());
        areaService.getAreasBySuburb(SUBURB);

        //then
        verify(areaRepository).findAreaBySuburb(SUBURB);
    }

    @Test
    void cannotGetAreasBySuburb() throws SuburbNotFoundException {
        //when
        when(areaRepository.findAreaBySuburb(SUBURB)).thenReturn(new ArrayList<>());
        String expectedExceptionMessage = String.format("The provided suburb (%s) could not be found.", SUBURB);

        Exception exception = assertThrows(SuburbNotFoundException.class, () -> {
            areaService.getAreasBySuburb(SUBURB);
        });
        String actualExceptionMessage = exception.getMessage();

        //then
        verify(areaRepository).findAreaBySuburb(SUBURB);
        assertTrue(actualExceptionMessage.contains(expectedExceptionMessage));
    }

    @Test
    void canAddNewArea() throws ResourceAlreadyExistsException {
        //when
        Area area = getArea();
        when(areaRepository.findAreaByPostcodeAndSuburb(POSTCODE, SUBURB)).thenReturn(Optional.empty());
        when(areaRepository.save(area)).thenReturn(area);

        areaService.addNewArea(area);

        //then
        verify(areaRepository).findAreaByPostcodeAndSuburb(POSTCODE, SUBURB);
        verify(areaRepository).save(area);

    }

    @Test
    void canNotAddNewArea() throws ResourceAlreadyExistsException {
        //when
        Area area = getArea();
        String expectedExceptionMessage = String.format("This Postcode (%s) and Suburb (%s) combination already exists.",area.getPostcode().toString(),area.getSuburb());
        when(areaRepository.findAreaByPostcodeAndSuburb(POSTCODE, SUBURB)).thenReturn(Optional.ofNullable(area));

        Exception exception = assertThrows(ResourceAlreadyExistsException.class, () -> {
                areaService.addNewArea(area);
        });
        String actualExceptionMessage = exception.getMessage();


        //then
        verify(areaRepository).findAreaByPostcodeAndSuburb(POSTCODE, SUBURB);
        assertTrue(actualExceptionMessage.contains(expectedExceptionMessage));
    }

    private List<Area> getAreaList() {
        return asList(getArea());
    }

    private Area getArea() {
        return Area.builder()
                .postcode(POSTCODE)
                .suburb(SUBURB)
                .build();
    }
}