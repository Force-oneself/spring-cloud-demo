package pers.quan.cloud.mysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.quan.cloud.mysql.service.LdService;

@RestController
public class LdController {

	@Autowired
	private LdService ldService;
	
	@GetMapping("/test")
	public String test() {
		System.err.println(ldService.count());
		return "success";
	}
}
