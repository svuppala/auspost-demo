package com.example.demo.area;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(AreaId.class)
public class Area {

    @Id
    private int postcode;

    @Id
    private String suburb;

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public Area(int postcode, String suburb) {
        this.postcode = postcode;
        this.suburb = suburb;
    }

    public Area() {
    }
}
