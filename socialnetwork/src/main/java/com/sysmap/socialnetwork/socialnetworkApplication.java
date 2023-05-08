package com.sysmap.socialnetwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableKafka
public class socialnetworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(socialnetworkApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() { //Motor de encriptação de senha
        return new BCryptPasswordEncoder();
    }
}
