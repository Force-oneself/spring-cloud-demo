package pers.quan.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableScheduling
@EnableFeignClients
@EnableZuulProxy
@EnableSwagger2
public class CloudAuthJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudAuthJwtApplication.class, args);
    }

}
