package br.com.fiap.pagseguro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class FiapOnApplication {

    public static void main(String[] args) {
        SpringApplication.run(FiapOnApplication.class, args);
    }

}