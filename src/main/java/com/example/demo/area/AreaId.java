package com.example.demo.area;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class AreaId implements Serializable {
    private Integer postcode;
    private String suburb;
}
