package com.fxb.util;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 配置类
 */
@Component
public class MyInterceptorConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/gotoLogin","/loginUser","/static/**","/page/**");
	}
	/**
	 * 放过静态资源
	 */
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		 registry.addResourceHandler("/page/**").addResourceLocations("classpath:/page/");
	    }

	/**
	 * 跨域
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**")
//				.allowedMethods("*")  //允许所有的请求方式
//				.allowedOrigins("*")//允许所有的请求域名
//				.allowedHeaders("*");//允许所有的请求头
	}


	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index");
		registry.addRedirectViewController("/index","/templates/index.html");
		registry.addStatusController("/403", HttpStatus.FORBIDDEN);
	}
}
