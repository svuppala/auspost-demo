package com.example.demo.area;

import com.example.demo.exceptions.PostCodeNotFoundException;
import com.example.demo.exceptions.ResourceAlreadyExistsException;
import com.example.demo.exceptions.SuburbNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService {

    private final AreaRepository areaRepository;

    @Autowired
    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public List<Area> getAreasByPostCode(Integer postcode) throws PostCodeNotFoundException {
        List<Area> areasByPostcode = areaRepository.findAreaByPostcode(postcode);
        if (areasByPostcode.isEmpty()) {
            throw new PostCodeNotFoundException(String.format("The provided postcode (%d) could not be found.", postcode));
        }
        return areasByPostcode;
    }

    public List<Area> getAreasBySuburb(String suburb) throws SuburbNotFoundException {
        List<Area> areasBySuburb = areaRepository.findAreaBySuburb(suburb);
        if (areasBySuburb.isEmpty()) {
            throw new SuburbNotFoundException(String.format("The provided suburb (%s) could not be found.", suburb));
        }
        return areasBySuburb;
    }

    public Area addNewArea(Area area) throws ResourceAlreadyExistsException {
        Optional<Area> areaByOptional = areaRepository.findAreaByPostcodeAndSuburb(area.getPostcode(), area.getSuburb());
        if (areaByOptional.isPresent()) {
            throw new ResourceAlreadyExistsException(String.format("This Postcode (%s) and Suburb (%s) combination already exists.",area.getPostcode().toString(),area.getSuburb()));
        }
        return areaRepository.save(area);
    }
}
