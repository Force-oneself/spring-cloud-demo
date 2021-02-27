package pers.quan.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author heyq
 * @Date 2021-02-26
 **/
@RestController
public class HelloController {

    @GetMapping("/")
    public String hello(){
        return "root hello";
    }
}
