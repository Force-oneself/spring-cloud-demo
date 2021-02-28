package pers.quan.cloud.config;

import feign.Contract;
import feign.Logger;
import feign.Request;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import org.springframework.cloud.openfeign.support.DefaultGzipDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.quan.cloud.interceptor.FeignBasicAuthRequestInterceptor;

import java.util.concurrent.TimeUnit;


/**
 * @Description: FeignConfiguration
 * @Author heyq
 * @Date 2021-02-27
 **/
@Configuration
public class FeignConfiguration {

    /**
     * 日志级别
     * NONE:不输出日志
     * BASIC:只输出请求方法的URL和响应的状态码以及接口执行的时间
     * HEADERS:将BASIC信息和请求头信息输出
     * FULL:输出完整的请求信息
     *
     * @return feign的日志级别
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 启用默认契约配置,不在支持SpringMVC注解
     * SpringCloud中默认SpringMvcContract
     *
     * @return
     */
//    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }

    /**
     * basic认证,通过请求头传递认证信息
     *
     * @return basic认证
     */
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password");
    }

    /**
     * 创建Feign请求拦截器，在发送请求前设置认证的token,各个微服务将token设置 到环境变量中来达到通用
     *
     * @return
     */
    @Bean
    public FeignBasicAuthRequestInterceptor feignBasicAuthRequestInterceptor() {
        return new FeignBasicAuthRequestInterceptor();
    }

    /**
     * 连接超时时间和取超时时间配置
     *
     * @return
     */
    @Bean
    public Request.Options options() {
        // 默认10*1000 , 60*1000
        return new Request.Options(5000, TimeUnit.MILLISECONDS, 10000, TimeUnit.MILLISECONDS, true);
    }
}
