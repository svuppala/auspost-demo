package com.example.demo.area;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AreaRepositoryTest {

    @Autowired
    private AreaRepository areaRepository;

    @AfterEach
    void tearDown() {
        areaRepository.deleteAll();
    }

    @Test
    void itShouldFindAreaByPostcodeWhenMatchingDataExists() {
        //given
        Area area = new Area(
                3168,
                "Clayton"
        );
        areaRepository.save(area);

        //when
        List<Area> expectedAreaList = areaRepository.findAreaByPostcode(3168);

        //then
        assertThat(expectedAreaList.size()).isEqualTo(1);
        assertThat(expectedAreaList.get(0).getPostcode()).isEqualTo(area.getPostcode());
        assertThat(expectedAreaList.get(0).getSuburb()).isEqualTo(area.getSuburb());

    }

    @Test
    void itShouldNotFindAreaByPostcodeWhenMatchingDataDoesNotExist() {
        //given
        Area area = new Area(
                3168,
                "Clayton"
        );
        areaRepository.save(area);

        //when
        List<Area> expectedAreaList = areaRepository.findAreaByPostcode(3169);

        //then
        assertThat(expectedAreaList.size()).isEqualTo(0);
    }

    @Test
    void itShouldFindAreaBySuburbWhenMatchingDataExists() {
        //given
        Area area = new Area(
                3168,
                "Clayton"
        );
        areaRepository.save(area);

        //when
        List<Area> expectedAreaList = areaRepository.findAreaBySuburb("Clayton");

        //then
        assertThat(expectedAreaList.size()).isEqualTo(1);
        assertThat(expectedAreaList.get(0).getPostcode()).isEqualTo(area.getPostcode());
        assertThat(expectedAreaList.get(0).getSuburb()).isEqualTo(area.getSuburb());

    }

    @Test
    void itShouldNotFindAreaBySuburbWhenMatchingDataDoesNotExist() {
        //given
        Area area = new Area(
                3168,
                "Clayton"
        );
        areaRepository.save(area);

        //when
        List<Area> expectedAreaList = areaRepository.findAreaBySuburb("Nottinghill");

        //then
        assertThat(expectedAreaList.size()).isEqualTo(0);
    }

    @Test
    void itShouldFindAreaByPostcodeAndSuburbWhenMatchingDataExists() {
        //given
        Area area = new Area(
                3168,
                "Clayton"
        );
        areaRepository.save(area);

        //when
        Optional<Area> expectedArea = areaRepository.findAreaByPostcodeAndSuburb(3168,"Clayton");

        //then
        assertTrue(expectedArea.isPresent());
        assertThat(expectedArea.get().getSuburb()).isEqualTo(area.getSuburb());
        assertThat(expectedArea.get().getPostcode()).isEqualTo(area.getPostcode());
    }

    @Test
    void itShouldNotFindAreaByPostcodeAndSuburbWhenMatchingDataDoesNotExist() {
        //given
        Area area = new Area(
                3168,
                "Clayton"
        );
        areaRepository.save(area);

        //when
        Optional<Area> expectedArea = areaRepository.findAreaByPostcodeAndSuburb(3168,"Nottinghill");

        //then
        assertFalse(expectedArea.isPresent());
    }
}