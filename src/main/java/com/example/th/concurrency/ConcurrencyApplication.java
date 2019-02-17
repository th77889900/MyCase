package com.example.th.concurrency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.Phased;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.Filter;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
public class ConcurrencyApplication extends WebMvcConfigurationSupport {

	public static void main(String[] args) {
		SpringApplication.run(ConcurrencyApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean httpFilter() {

		FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
		bean.setFilter(new Httpfilter());
		bean.addUrlPatterns("/threadLoacl/*");
		return bean;
	}

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HttpIntercepter()).addPathPatterns("/**");
	}
}

