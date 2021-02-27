package pers.quan.cloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

/**
 * @Description:
 * @Author heyq
 * @Date 2021-02-27
 **/
@Configuration
@Slf4j
public class GlobalFilterConfiguration {

    @Order(-1)
    @Bean
    public GlobalFilter first(){
        return (exchange, chain) -> {
            log.info("first pre filter");
            return chain.filter(exchange).then(Mono.fromRunnable(()->log.info("third post filter")));
        };
    }

    @Order(0)
    @Bean
    public GlobalFilter second(){
        return (exchange, chain) -> {
            log.info("second pre filter");
            return chain.filter(exchange).then(Mono.fromRunnable(()->log.info("second post filter")));
        };
    }

    @Order(1)
    @Bean
    public GlobalFilter third(){
        return (exchange, chain) -> {
            log.info("third pre filter");
            return chain.filter(exchange).then(Mono.fromRunnable(()->log.info("first post filter")));
        };
    }
}
