package com.example.demo.area;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Builder
@Table
@AllArgsConstructor
@NoArgsConstructor
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

}
