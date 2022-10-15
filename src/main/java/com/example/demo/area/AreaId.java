package com.example.demo.area;

import java.io.Serializable;

public class AreaId implements Serializable {
    private Integer postcode;
    private String suburb;

    public AreaId() {
    }

    public AreaId(Integer postcode, String suburb) {
        this.postcode = postcode;
        this.suburb = suburb;
    }

}
