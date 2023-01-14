package com.springboot.app.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.commons.springbootcommons.models.entity"})
public class SpringbootServiceProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootServiceProductsApplication.class, args);
    }

}
