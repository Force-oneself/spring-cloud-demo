package pers.quan.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author heyq
 * @Date 2021-02-27
 **/
@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/hello")
    public String hello() {
        return "auth hello";
    }
}
