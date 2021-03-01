package pers.quan.cloud.interceptor;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import pers.quan.cloud.support.RibbonFilterContextHolder;

import java.util.Map;

public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {
	
	public FeignBasicAuthRequestInterceptor() {

	}

	public void apply(RequestTemplate template) {
//		System.err.println("进入拦截器了");
		template.header("Authorization", System.getProperty("fangjia.auth.token"));

		Map<String, String> attributes = RibbonFilterContextHolder.getCurrentContext().getAttributes();
		for (String key : attributes.keySet()) {
			String value = attributes.get(key);
			template.header(key, value);
		}
	}

}
