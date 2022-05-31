package com.springboot.demo2.springbootdemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringBootDemo2Application {

	// @Bean
	// public WebMvcConfigurer corsConfigurer() {
	// return addCorsMappings(registry) {
	// registry.addMapping("/**")
	// .allowedOrigins("*")
	// .allowedOrigins("GET","POST","PUT","PATCH","DELETE","OPTIONS")
	// .allowedOrigins("*")
	// .allowedOrigins(false)
	// .maxAge(3600) ;
	// };
	// }
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo2Application.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:8080");
			}
		};
	}

}
