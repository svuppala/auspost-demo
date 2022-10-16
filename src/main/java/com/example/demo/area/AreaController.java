package com.example.demo.area;

import com.example.demo.exceptions.PostCodeNotFoundException;
import com.example.demo.exceptions.ResourceAlreadyExistsException;
import com.example.demo.exceptions.SuburbNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Web Request Handler for GET and POST endpoints related to Area (postcode and suburb)
 */
// to change Cross Origin as necessary
@CrossOrigin("http://localhost:8080")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/area")
public class AreaController {

    private final AreaService areaService;

    private final AreaResponseMapper areaResponseMapper;

    /**
     * Get Endpoint to return a list of related suburbs
     * @param postcode the postcode to search for related suburbs
     * @return Returns a list of objects of related suburbs along with HTTP status
     * @throws PostCodeNotFoundException
     */
    @GetMapping(path = "/suburb/{postcode}")
    public ResponseEntity<List<AreaSuburbResponse>> getSuburbs(@PathVariable("postcode") Integer postcode) throws PostCodeNotFoundException {
        return ResponseEntity.ok(areaResponseMapper.toAreaSuburbResponses(areaService.getAreasByPostCode(postcode)));
    }

    /**
     * Get Endpoint to return a list of related postcodes
     * @param suburb the suburb to search for related postcodes
     * @return Returns a list of objects of related postcodes along with HTTP status
     * @throws SuburbNotFoundException
     */
    @GetMapping(path = "/postcode/{suburb}")
    public ResponseEntity<List<AreaPostcodeResponse>> getPostcodes(@PathVariable("suburb") String suburb) throws SuburbNotFoundException {
        return ResponseEntity.ok(areaResponseMapper.toAreaPostcodeResponses(areaService.getAreasBySuburb(suburb)));
    }

    /**
     * Post Endpoint to save a combination of postcode and suburb
     * @param createAreaRequest the combination of postcode and suburb to save
     * @return Returns the combination of postcode and suburb it stored along with HTTP status
     * @throws ResourceAlreadyExistsException
     */
    @PostMapping
    public ResponseEntity<Area> registerNewArea(@RequestBody @Valid CreateAreaRequest createAreaRequest) throws ResourceAlreadyExistsException {
        return new ResponseEntity<>(areaService.addNewArea(areaResponseMapper.toArea(createAreaRequest)), HttpStatus.CREATED);
    }
}
