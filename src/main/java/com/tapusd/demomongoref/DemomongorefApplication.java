package com.tapusd.demomongoref;

import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongock
public class DemomongorefApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemomongorefApplication.class, args);
    }

}
