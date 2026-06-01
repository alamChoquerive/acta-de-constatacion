package com.example.acta_de_constatacion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
    "com.example.acta_de_constatacion",
    "Controller",
    "Service",
    "Repository",
    "Model"
})
@EntityScan(basePackages = {"Model"})
@EnableJpaRepositories(basePackages = {"Repository"})
public class ActaDeConstatacionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActaDeConstatacionApplication.class, args);
    }
}