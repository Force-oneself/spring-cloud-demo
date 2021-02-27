package pers.quan.cloud.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import pers.quan.cloud.config.FeignConfiguration;


@FeignClient(
		value="cloud-feign-service",
		// 指定类降级方法
//		fallback = RemoteClientFallback.class,
		// 指定使用的配置类
//		configuration = FeignConfiguration.class,
		// 指定工厂降级
		fallbackFactory = RemoteClientFallbackFactory.class)
public interface RemoteClient {

	@GetMapping("/")
	String hello();

	@GetMapping("/auth/hello")
	String authHello();
	
}
