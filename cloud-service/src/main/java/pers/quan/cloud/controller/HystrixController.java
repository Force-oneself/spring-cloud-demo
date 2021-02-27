package pers.quan.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author heyq
 * @Date 2021-02-26
 **/
@RestController
@RequestMapping("/hystrix")
public class HystrixController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    @HystrixCommand(fallbackMethod = "defaultCallHello", commandProperties = {
            @HystrixProperty(name="execution.isolation.strategy", value = "THREAD")
    }
    )
    public String callHello() {
        String result = restTemplate.getForObject("http://localhost:8090/", String.class);
        return result;
    }

    public String defaultCallHello() {
        return "fail";
    }
}
