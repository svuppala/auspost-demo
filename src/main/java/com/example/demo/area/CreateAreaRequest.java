package com.example.demo.area;

import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
public class CreateAreaRequest {

    private static final String MISSING_IN_THE_BODY_MESSAGE ="is missing in the body";
    @NotNull(message = "Postcode "+ MISSING_IN_THE_BODY_MESSAGE)
    private Integer postcode;

    @NotBlank(message = "Suburb "+ MISSING_IN_THE_BODY_MESSAGE)
    private String suburb;

    public CreateAreaRequest(Integer postcode, String suburb) {
        this.postcode = postcode;
        this.suburb = suburb;
    }

    public CreateAreaRequest() {
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }
}
