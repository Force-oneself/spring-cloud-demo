package pers.quan.cloud.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import pers.quan.cloud.common.filter.HttpBasicAuthorizeFilter;

import java.util.ArrayList;
import java.util.List;
/**
 * @Description:
 * @Author heyq
 * @Date 2021-02-28
 **/
@Configuration
public class BeanConfig {

    @Bean
    public FilterRegistrationBean<HttpBasicAuthorizeFilter> filterRegistrationBean() {
        FilterRegistrationBean<HttpBasicAuthorizeFilter> registrationBean = new FilterRegistrationBean<>();
        HttpBasicAuthorizeFilter httpBasicFilter = new HttpBasicAuthorizeFilter();
        registrationBean.setFilter(httpBasicFilter);
        List<String> urlPatterns = new ArrayList<>(1);
        urlPatterns.add("/*");
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }
}
