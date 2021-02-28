package pers.quan.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pers.quan.cloud.remote.AuthRemoteClient;
import pers.quan.cloud.remote.RemoteClient;

/**
 * @Description:
 * @Author heyq
 * @Date 2021-02-27
 **/
@RestController
@RequestMapping("/auth")
public class AuthController {

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RemoteClient remoteClient;

    @GetMapping("/callHello")
    public String callHello() {
        logger.info("我是/article/callHello");
        return restTemplate.getForObject("http://cloud-feign-service/auth/hello", String.class);
    }

    @GetMapping("/remote/hello")
    public String callHello2() {
        logger.info("我是/article/callHello2");
        return remoteClient.hello();
    }

    @GetMapping("/hello")
    public String hello() {
        return "auth hello";
    }
}
