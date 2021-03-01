package pers.quan.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.quan.cloud.filter.AuthFilter;
import pers.quan.cloud.filter.DebugRequestFilter;
import pers.quan.cloud.filter.DownGradeFilter;
import pers.quan.cloud.filter.ErrorFilter;
import pers.quan.cloud.filter.GrayPushFilter;
import pers.quan.cloud.filter.IpFilter;
import pers.quan.cloud.filter.LimitFilter;


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

	@Bean
	public AuthFilter authFilter() {
		return new AuthFilter();
	}

	@Bean
	public LimitFilter limitFilter() {
		return new LimitFilter();
	}

	//@Bean
	public DownGradeFilter downGradeFilter() {
		return new DownGradeFilter();
	}
	@Bean
	public GrayPushFilter grayPushFilter() {
		return new GrayPushFilter();
	}
}
