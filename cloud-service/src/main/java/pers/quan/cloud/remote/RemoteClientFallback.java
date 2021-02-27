package pers.quan.cloud.remote;

import org.springframework.stereotype.Component;

@Component
public class RemoteClientFallback implements RemoteClient {

	@Override
	public String hello() {
		return "fail";
	}

	@Override
	public String authHello() {
		return "auth fail";
	}

}
