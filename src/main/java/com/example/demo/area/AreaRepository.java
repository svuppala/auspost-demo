package com.example.demo.area;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AreaRepository extends JpaRepository<Area, AreaId> {
    List<Area> findAreaByPostcode(Integer postcode);
    List<Area> findAreaBySuburb(String suburb);
    Optional<Area> findAreaByPostcodeAndSuburb(Integer postcode, String suburb);
}
