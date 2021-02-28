package pers.quan.cloud.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudAuthServiceApplication.class, args);
    }

}
