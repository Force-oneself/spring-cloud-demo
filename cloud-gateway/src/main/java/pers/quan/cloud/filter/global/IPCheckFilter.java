package pers.quan.cloud.filter.global;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import pers.quan.cloud.util.JsonUtils;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author heyq
 * @Date 2021-02-27
 **/
@Component
public class IPCheckFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders httpHeaders = exchange.getRequest().getHeaders();
        // 此处写的非常绝对,实际需要采用配置的方式
        if (getIP(httpHeaders).equals("127.0.0.1")) {
            ServerHttpResponse response = exchange.getResponse();
            Map<String,Object> map = new HashMap<>();
            map.put("code", 401);
            map.put("message", "非法请求");
            byte[] bytes = JsonUtils.toJson(map).getBytes(StandardCharsets.UTF_8);
            DataBuffer dataBuffer = response.bufferFactory().wrap(bytes);
            response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
            return response.writeWith(Mono.just(dataBuffer));
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

    /**
     * 这里从请求头中获取用户的实际ip,根据Nginx转发的请求头获取
     * @param httpHeaders
     * @return
     */
    private String getIP(HttpHeaders httpHeaders) {
        return "127.0.0.1";
    }
}
