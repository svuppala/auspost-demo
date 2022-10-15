package com.example.demo.area;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<Area, AreaId> {
    List<Area> findAreaByPostcode(int postcode);
    List<Area> findAreaBySuburb(String suburb);
}
