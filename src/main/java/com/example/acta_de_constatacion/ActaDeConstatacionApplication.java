package com.example.acta_de_constatacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * CAMBIO: En lugar de crear manualmente el EntityManagerFactory y lanzar JFrames,
 * Spring Boot arranca el contexto completo (IoC container, JPA, Tomcat embebido)
 * con una sola anotación: @SpringBootApplication.
 *
 * @SpringBootApplication equivale a:
 *   @Configuration         -> esta clase es fuente de beans
 *   @EnableAutoConfiguration -> configura automáticamente JPA, MVC, etc.
 *   @ComponentScan         -> escanea todos los @Component/@Service/@Controller
 *                            del paquete com.actas y sus subpaquetes
 */
@SpringBootApplication(scanBasePackages = {
    "com.example.acta_de_constatacion",
    "Controller",
        "Model",
        "Repository",
    "Service"

})
@org.springframework.boot.autoconfigure.domain.EntityScan(basePackages = {"Model"})
@EnableJpaRepositories(basePackages = {"Repository"})
public class ActaDeConstatacionApplication {

    public static void main(String[] args) {
        // Antes: creaban EntityManagerFactory y abrían JFrame
        // Ahora: Spring Boot levanta todo (Tomcat, JPA, MVC) y escucha en localhost:8080
        SpringApplication.run(ActaDeConstatacionApplication.class, args);
    }
}