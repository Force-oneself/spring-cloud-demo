package pers.quan.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.quan.cloud.filter.DebugRequestFilter;
import pers.quan.cloud.filter.ErrorFilter;
import pers.quan.cloud.filter.IpFilter;


@Configuration
public class FilterConfig {

	@Bean
	public IpFilter ipFilter() {
		return new IpFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	
	@Bean
	public DebugRequestFilter debugRequestFilter() {
		return new DebugRequestFilter();
	}
}
