package com.example.embedsocial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class EmbedsocialApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmbedsocialApplication.class, args);
    }

}
