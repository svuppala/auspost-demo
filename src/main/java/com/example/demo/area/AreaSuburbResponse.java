package com.example.demo.area;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AreaSuburbResponse {
    private String suburb;

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }
}
