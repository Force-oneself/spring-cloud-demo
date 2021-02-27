package pers.quan.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.quan.cloud.remote.RemoteClient;


@RestController
@RequestMapping("/feign")
public class RemoteController {

	@Autowired
	private RemoteClient userRemoteClient;

	@GetMapping("/hello")
	public String callHello() {
		System.err.println("进来了。。。。。");
		//System.err.println(2/0);
		String result = userRemoteClient.hello();
		System.out.println(" 调用结果：" + result);
		return result;
	}

	@GetMapping("/auth")
	public String authHello() {
		return userRemoteClient.authHello();
	}
}
