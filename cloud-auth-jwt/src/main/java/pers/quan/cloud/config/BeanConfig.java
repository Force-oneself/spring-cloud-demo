package pers.quan.cloud.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.quan.cloud.filter.AuthHeaderFilter;

@Configuration
public class BeanConfig {

	@Bean
	public AuthHeaderFilter authHeaderFilter() {
		return new AuthHeaderFilter();
	}
}
