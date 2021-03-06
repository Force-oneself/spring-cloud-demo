package pers.quan.cloud.interceptor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * RestTemplate拦截器，传递认证的Token
 * @author yinjihuan
 *
 */
@Component
public class TokenInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		System.err.println("进入RestTemplate拦截器");
		HttpHeaders headers = request.getHeaders();
	    headers.add("authorization", System.getProperty("fangjia.auth.token"));
	    return execution.execute(request, body);
	}

}
