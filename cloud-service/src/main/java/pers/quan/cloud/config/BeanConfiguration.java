package pers.quan.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import pers.quan.cloud.apilimit.ApiLimitAspect;
import pers.quan.cloud.filter.HttpHeaderParamFilter;
import pers.quan.cloud.interceptor.FeignBasicAuthRequestInterceptor;
import pers.quan.cloud.interceptor.TokenInterceptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

	@Bean
	public FilterRegistrationBean<HttpHeaderParamFilter> filterRegistrationBean() {
		FilterRegistrationBean<HttpHeaderParamFilter> registrationBean = new FilterRegistrationBean<>();
		HttpHeaderParamFilter httpHeaderParamFilter = new HttpHeaderParamFilter();
		registrationBean.setFilter(httpHeaderParamFilter);
		List<String> urlPatterns = new ArrayList<>(1);
		urlPatterns.add("/*");
		registrationBean.setUrlPatterns(urlPatterns);
		return registrationBean;
	}

	@Bean
	public FeignBasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new FeignBasicAuthRequestInterceptor();
	}

	@Bean
	public ApiLimitAspect apiLimitAspect() {
		return new ApiLimitAspect();
	}
}
