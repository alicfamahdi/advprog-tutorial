package id.ac.ui.cs.advprog.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@SpringBootApplication
public class EshopApplication {
    private static final Logger logger = LoggerFactory.getLogger(EshopApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EshopApplication.class, args);
        String port = Optional.ofNullable(System.getenv("PORT")).orElse("8080");
        logger.info("Application started on port: {}", port);
    }
}
