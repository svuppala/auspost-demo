package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner2(StudentRepository studentRepository) {
        return args -> {
            Student sriram = new Student(
                    "Sriram",
                    "Sriram@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            Student kavi = new Student(
                    "Kavi",
                    "Kavi@gmail.com",
                    LocalDate.of(2004, Month.JANUARY, 5)
            );

            studentRepository.saveAll(List.of(sriram,kavi));
        };
    }
}
