package com.example.demo.area;

import com.example.demo.exceptions.PostCodeNotFoundException;
import com.example.demo.exceptions.ResourceAlreadyExistsException;
import com.example.demo.exceptions.SuburbNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The AreaService Class handles all the business logic.
 * It invokes methods in the AreaRepository to retrieve and store data.
 */
@Service
@AllArgsConstructor
public class AreaService {

    private final AreaRepository areaRepository;

    /**
     * Return all the Areas that match the postcode
     * @param postcode the postcode to search related suburbs
     * @return A list of Areas that match the postcode
     * @throws PostCodeNotFoundException
     */
    public List<Area> getAreasByPostCode(Integer postcode) throws PostCodeNotFoundException {
        List<Area> areasByPostcode = areaRepository.findAreaByPostcode(postcode);
        if (areasByPostcode.isEmpty()) {
            throw new PostCodeNotFoundException(String.format("The provided postcode (%d) could not be found.", postcode));
        }
        return areasByPostcode;
    }

    /**
     * Return all the Areas that match the suburb
     * @param suburb the suburb to search related postcodes
     * @return A list of Areas that match the suburb
     * @throws SuburbNotFoundException
     */
    public List<Area> getAreasBySuburb(String suburb) throws SuburbNotFoundException {
        List<Area> areasBySuburb = areaRepository.findAreaBySuburb(suburb);
        if (areasBySuburb.isEmpty()) {
            throw new SuburbNotFoundException(String.format("The provided suburb (%s) could not be found.", suburb));
        }
        return areasBySuburb;
    }

    /**
     * Return the Area that has been saved
     * @param area the combination of postcode and suburb to save
     * @return saved Area
     * @throws ResourceAlreadyExistsException
     */
    public Area addNewArea(Area area) throws ResourceAlreadyExistsException {
        Optional<Area> areaByOptional = areaRepository.findAreaByPostcodeAndSuburb(area.getPostcode(), area.getSuburb());
        if (areaByOptional.isPresent()) {
            throw new ResourceAlreadyExistsException(String.format("This Postcode (%s) and Suburb (%s) combination already exists.",area.getPostcode().toString(),area.getSuburb()));
        }
        return areaRepository.save(area);
    }
}
