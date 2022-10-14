package com.example.demo.area;

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

    public int getPostCode() {
        return postcode;
    }

    public void setPostCode(int postcode) {
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
