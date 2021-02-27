package pers.quan.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableHystrixDashboard
@EnableEurekaClient
@EnableTurbine
public class CloudHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudHystrixDashboardApplication.class, args);
    }

}
