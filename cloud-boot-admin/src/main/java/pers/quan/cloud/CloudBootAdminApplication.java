package pers.quan.cloud;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableAdminServer
@EnableEurekaClient
@EnableEncryptableProperties
public class CloudBootAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudBootAdminApplication.class, args);
    }

}
