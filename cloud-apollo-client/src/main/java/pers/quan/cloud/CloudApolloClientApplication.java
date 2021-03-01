package pers.quan.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudApolloClientApplication {

    public static void main(String[] args) {
        // 指定环境（开发演示用，不能用于生产环境））
        System.setProperty("env", "DEV");
        SpringApplication.run(CloudApolloClientApplication.class, args);
    }

}
