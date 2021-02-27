package pers.quan.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import brave.Tracer;
import pers.quan.cloud.service.ArticleService;

@RestController
public class ArticleController {

	private Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired 	
	private RestTemplate restTemplate;  	
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired 
	Tracer tracer;
	
	@GetMapping("/article/callHello") 	
	public String callHello() { 		
		logger.info("我是/article/callHello");
		tracer.currentSpan().tag("用户", "yinjihuan");
		articleService.saveLog("test");
		articleService.saveLog2("test");
	    return restTemplate.getForObject(
			"http://cloud-service/", String.class);
	}
	
}
