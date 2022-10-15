package com.example.demo.area;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class AreaControllerIntegrationTest {

    private static final Integer POSTCODE = 3168;
    private static final String SUBURB = "Clayton";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AreaService areaService;

    @MockBean
    private AreaResponseMapper areaResponseMapper;

    @Test
    void shouldGetSuburbsWithoutCSRF() throws Exception {
        when(areaService.getAreasBySuburb(SUBURB)).thenReturn(getAreaList());
        when(areaResponseMapper.toAreaSuburbResponses(getAreaList())).thenReturn(getAreaSuburbResponses());


        mockMvc.perform(get("http://localhost:8080/api/v1/area/suburb/3168").with(httpBasic("demoUserName","demoUserPassword")))
                .andDo(print())
                .andExpect(status().isUnauthorized());

    }

    @Test
    void shouldGetSuburbsWithSuccess() throws Exception {
        when(areaService.getAreasBySuburb(SUBURB)).thenReturn(getAreaList());
        when(areaResponseMapper.toAreaSuburbResponses(getAreaList())).thenReturn(getAreaSuburbResponses());


        mockMvc.perform(get("http://localhost:8080/api/v1/area/suburb/3168").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void shouldGetPostcodesWithSuccess() throws Exception {
        when(areaService.getAreasByPostCode(POSTCODE)).thenReturn(getAreaList());
        when(areaResponseMapper.toAreaPostcodeResponses(getAreaList())).thenReturn(getAreaPostcodeResponses());


        mockMvc.perform(get("http://localhost:8080/api/v1/area/postcode/clayton").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void registerNewAreaWithoutCSRFFailure() throws Exception {
        when(areaService.addNewArea(getArea())).thenReturn(getArea());
        when(areaResponseMapper.toArea(getCreateAreaRequest())).thenReturn(getArea());


        mockMvc.perform(post("http://localhost:8080/api/v1/area/postcode").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
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