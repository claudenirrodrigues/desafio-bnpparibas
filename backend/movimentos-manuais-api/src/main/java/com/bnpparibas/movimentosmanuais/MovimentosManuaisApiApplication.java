package com.bnpparibas.movimentosmanuais;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MovimentosManuaisApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovimentosManuaisApiApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("GET", "POST", "PUT", "DELETE")
						.allowedOrigins("http://localhost:4200")
						.allowedHeaders("header1", "header2", "header3")
			            .exposedHeaders("header1", "header2")
			            .allowCredentials(false).maxAge(3600);
			}
		};
	}
	

}
