package com.example.demo.area;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(AreaId.class)
public class Area {

    @Id
    private Integer postcode;

    @Id
    private String suburb;

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

    public Area() {
    }

    public Area(Integer postcode, String suburb) {
        this.postcode = postcode;
        this.suburb = suburb;
    }
}
