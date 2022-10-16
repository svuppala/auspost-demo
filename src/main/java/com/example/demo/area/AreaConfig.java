package com.example.demo.area;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AreaConfig {

    /***
     * Used to Load Data into the Database when the application starts
     * @param areaRepository Repository with which the Area data is going to be stored
     */
    @Bean
    CommandLineRunner commandLineRunner(AreaRepository areaRepository) {
        return args -> {
            Area area1 = new Area(
                    3168,
                    "Clayton"
            );

            Area area2 = new Area(
                    3168,
                    "Nottinghill"
                        );

            Area area3 = new Area(
                    3170,
                    "Mulgrave"
                        );

            Area area4 = new Area(
                        3000,
                        "Melbourne"
                        );

            Area area5 = new Area(
                        2150,
                        "Paramatta"
                        );

            Area area6 = new Area(
                        2124,
                        "Paramatta"
                        );

            areaRepository.saveAll(List.of(area1, area2, area3, area4, area5, area6));
        };
    }
}