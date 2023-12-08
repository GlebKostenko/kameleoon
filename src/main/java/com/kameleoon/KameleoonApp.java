package com.kameleoon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.swing.*;

@SpringBootApplication
@EnableJpaAuditing
public class KameleoonApp {
    public static void main(String[] args) {
        SpringApplication.run(KameleoonApp.class, args);
    }
}
