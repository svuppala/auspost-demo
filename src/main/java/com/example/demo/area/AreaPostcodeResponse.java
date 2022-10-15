package com.example.demo.area;

import lombok.Builder;

@Builder
public class AreaPostcodeResponse {
    private int postcode;

    public AreaPostcodeResponse() {
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public AreaPostcodeResponse(int postcode) {
        this.postcode = postcode;
    }
}
