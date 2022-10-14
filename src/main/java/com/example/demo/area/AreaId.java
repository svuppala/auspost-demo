package com.example.demo.area;

import java.io.Serializable;

public class AreaId implements Serializable {
    private int postcode;
    private String suburb;

    public AreaId() {
    }

    public AreaId(int postcode, String suburb) {
        this.postcode = postcode;
        this.suburb = suburb;
    }

}
