package com.qinweizhao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author YVKG
 */
@EnableOpenApi
@SpringBootApplication
public class CalfStartApplication {


    public static void main(String[] args) {
        SpringApplication.run(CalfStartApplication.class, args);
    }

}
