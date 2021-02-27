package pers.quan.cloud.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class RemoteClientFallbackFactory implements FallbackFactory<RemoteClient> {

	private Logger logger = LoggerFactory.getLogger(RemoteClientFallbackFactory.class);
	
	@Override
	public RemoteClient create(Throwable cause) {
		logger.error("UserRemoteClient回退：", cause);
		return new RemoteClient() {
			@Override
			public String hello() {
				return "fail";
			}

			@Override
			public String authHello() {
				return "auth fail";
			}
		};
	}

}
