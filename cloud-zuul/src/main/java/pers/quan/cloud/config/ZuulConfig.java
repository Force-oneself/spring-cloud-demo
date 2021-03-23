package pers.quan.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalancedRetryFactory;
import org.springframework.cloud.netflix.zuul.filters.post.LocationRewriteFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.BackOffPolicy;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description:
 * @Author heyq
 * @Date 2021-03-23
 **/
@Configuration
public class ZuulConfig {

    /**
     * 如果Zuul在Web应用程序的前面，则当Web应用程序通过HTTP状态代码3XX重定向时，
     * 您可能需要重新编写Location标头*。否则，浏览器将重定向到Web应用程序的URL，而不是Zuul URL。
     * 您可以配置LocationRewriteFilter Zuul过滤器，以将Location标头*重新写入Zuul的网址。
     * 它还会添加回去的全局前缀和特定于路由的前缀。
     * 以下示例使用Spring配置文件添加了一个过滤器
     *
     * @return
     */
    @Bean
    public LocationRewriteFilter locationRewriteFilter() {
        return new LocationRewriteFilter();
    }

    /**
     * 默认情况下，Zuul将所有跨源请求（CORS）路由到服务。
     * 如果您希望Zuul处理这些请求，则可以通过提供自定义WebMvcConfigurer bean来完成
     * 在上面的示例中，我们允许allowed-origin.com的GET和POST方法将跨域请求发送到以path-1开头的端点。
     * 您可以使用/ **映射将CORS配置应用于特定的路径模式或整个应用程序的全局路径。
     * 您可以通过此配置来自定义属性：allowedOrigins，allowedMethods，allowedHeaders，exposedHeaders，allowCredentials和maxAge。
     *
     * @return
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/path-1/**")
                        .allowedOrigins("https://allowed-origin.com")
                        .allowedMethods("GET", "POST");
            }
        };
    }

    /**
     * 默认情况下，重试请求时不使用任何退避策略。如果要配置退避策略，则需要创建一个类型为LoadBalancedRetryFactory的Bean，
     * 并为给定服务覆盖createBackOffPolicy方法，如以下示例所示。
     *
     * @return
     */
    @Bean
    LoadBalancedRetryFactory retryFactory() {
        return new LoadBalancedRetryFactory() {
            @Override
            public BackOffPolicy createBackOffPolicy(String service) {
                return new ExponentialBackOffPolicy();
            }
        };
    }
}
