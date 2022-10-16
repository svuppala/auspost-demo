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

//to change CORS as necessary
@CrossOrigin("http://localhost:8080")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/area")
public class AreaController {

    private final AreaService areaService;

    private final AreaResponseMapper areaResponseMapper;

    @GetMapping(path = "/suburb/{postcode}")
    public ResponseEntity<List<AreaSuburbResponse>> getSuburbs(@PathVariable("postcode") Integer postcode) throws PostCodeNotFoundException {
        return ResponseEntity.ok(areaResponseMapper.toAreaSuburbResponses(areaService.getAreasByPostCode(postcode)));
    }

    @GetMapping(path = "/postcode/{suburb}")
    public ResponseEntity<List<AreaPostcodeResponse>> getPostcodes(@PathVariable("suburb") String suburb) throws SuburbNotFoundException {
        return ResponseEntity.ok(areaResponseMapper.toAreaPostcodeResponses(areaService.getAreasBySuburb(suburb)));
    }

    @PostMapping
    public ResponseEntity<Area> registerNewArea(@RequestBody @Valid CreateAreaRequest createAreaRequest) throws ResourceAlreadyExistsException {
        return new ResponseEntity<>(areaService.addNewArea(areaResponseMapper.toArea(createAreaRequest)), HttpStatus.CREATED);
    }
}
