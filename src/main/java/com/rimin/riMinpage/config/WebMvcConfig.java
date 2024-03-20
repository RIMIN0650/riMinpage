package com.rimin.riMinpage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.rimin.riMinpage.common.FileManager;
import com.rimin.riMinpage.interceptor.PermissionInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**")
		.addResourceLocations("file:///" + FileManager.FILE_UPLOAD_PATH + "/");
	}
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		PermissionInterceptor interceptor = new PermissionInterceptor();
		registry.addInterceptor(interceptor)
		.addPathPatterns("/**") // 만든 규칙에 대응되는 페이지만 거쳐가도록 안에 넣어주기
		.excludePathPatterns("/user/logout","/static/**", "/images/**");// 조건에 부합하지만 제외시킬 규칙
	}
	
	
	
	
	
	
	
}
