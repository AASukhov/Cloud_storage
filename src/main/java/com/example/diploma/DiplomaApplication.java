package com.example.diploma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ComponentScan({"com.example.diploma.repository"})
public class DiplomaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiplomaApplication.class, args);
    }
}
