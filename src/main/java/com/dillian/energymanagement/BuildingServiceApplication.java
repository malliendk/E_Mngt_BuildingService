package com.dillian.energymanagement;

import com.dillian.energymanagement.bootstrap.Generator;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@AllArgsConstructor
public class BuildingServiceApplication implements CommandLineRunner {

    private final Generator generator;

    public static void main(String[] args) {
        SpringApplication.run(BuildingServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        generator.saveBuildingsAndEvents();
    }
}
