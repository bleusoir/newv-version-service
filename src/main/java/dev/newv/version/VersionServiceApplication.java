package dev.newv.version;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import static org.springframework.boot.SpringApplication.run;

@EnableEurekaClient
@SpringBootApplication
public class VersionServiceApplication {

    public static void main(String[] args) {
        run(VersionServiceApplication.class, args);
    }
}