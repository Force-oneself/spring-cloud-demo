package pers.quan.cloud.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pers.quan.cloud.apilimit.ApiRateLimit;
import pers.quan.cloud.remote.AuthRemoteClient;

@RestController
public class ArticleController {
	
	@Autowired
	private AuthRemoteClient userRemoteClient;
	
	@Autowired
	private HttpServletRequest request;
	
	@ApiRateLimit(confKey = "open.api.callHello")
	@GetMapping("/article/callHello") 	
	public String callHello() {
		System.err.println("用户ID:" + request.getHeader("uid"));
	    return userRemoteClient.hello(); 	
	}
	
}
