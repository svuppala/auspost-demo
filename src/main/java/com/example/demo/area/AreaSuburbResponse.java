package com.example.demo.area;

import lombok.Builder;

@Builder
public class AreaSuburbResponse {
    private String suburb;

    public AreaSuburbResponse(String suburb) {
        this.suburb = suburb;
    }

    public AreaSuburbResponse() {
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }
}
