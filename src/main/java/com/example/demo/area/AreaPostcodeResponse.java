package com.example.demo.area;

import lombok.Builder;

@Builder
public class AreaPostcodeResponse {
    private Integer postcode;

    public AreaPostcodeResponse() {
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public AreaPostcodeResponse(Integer postcode) {
        this.postcode = postcode;
    }
}
