package com.patientQR.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.patientQR.myapp", "com.patientQR.services"}) 
@EntityScan("com.patientQR.entities")
@EnableJpaRepositories("com.patientQR.repositories")
public class DemoApplication extends SpringBootServletInitializer {
    
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
