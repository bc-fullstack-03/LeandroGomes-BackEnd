package com.sysmap.socialnetwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class socialnetworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(socialnetworkApplication.class, args);
    }
}
