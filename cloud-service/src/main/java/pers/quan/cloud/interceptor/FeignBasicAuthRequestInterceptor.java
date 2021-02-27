package pers.quan.cloud.interceptor;


import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {
	
	public FeignBasicAuthRequestInterceptor() {

	}

	public void apply(RequestTemplate template) {
		System.err.println("进入拦截器了");
		template.header("Authorization", System.getProperty("fangjia.auth.token"));
	}

}
