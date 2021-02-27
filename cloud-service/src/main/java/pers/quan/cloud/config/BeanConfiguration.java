package pers.quan.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import pers.quan.cloud.interceptor.TokenInterceptor;

import java.util.Collections;

@Configuration
public class BeanConfiguration {

	@Autowired
	private TokenInterceptor tokenInterceptor;

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setInterceptors(Collections.singletonList(tokenInterceptor));
		return restTemplate;
	}

	@Bean
	public IRule rule(){
		return new RandomRule();
	}
}
