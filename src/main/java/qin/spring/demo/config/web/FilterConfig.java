package qin.spring.demo.config.web;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import qin.spring.demo.modules.cors.CorsFilter;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<CorsFilter> registration() {
        CorsFilter corsFilter = new CorsFilter();
        FilterRegistrationBean<CorsFilter> registration = new FilterRegistrationBean<>(corsFilter);
        registration.addUrlPatterns("/*");
        return registration;
    }
}
