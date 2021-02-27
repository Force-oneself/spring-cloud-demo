package pers.quan.cloud.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.quan.cloud.filter.AuthHeaderFilter;
import pers.quan.cloud.filter.HttpBasicAuthorizeFilter;

@Configuration
public class BeanConfig {

	@Bean
	public AuthHeaderFilter authHeaderFilter() {
		return new AuthHeaderFilter();
	}

	@Bean
	public FilterRegistrationBean<HttpBasicAuthorizeFilter> filterRegistrationBean() {
		FilterRegistrationBean<HttpBasicAuthorizeFilter> registrationBean = new FilterRegistrationBean<HttpBasicAuthorizeFilter>();
		HttpBasicAuthorizeFilter httpBasicFilter = new HttpBasicAuthorizeFilter();
		registrationBean.setFilter(httpBasicFilter);
		List<String> urlPatterns = new ArrayList<String>(1);
		urlPatterns.add("/*");
		registrationBean.setUrlPatterns(urlPatterns);
		return registrationBean;
	}

}
