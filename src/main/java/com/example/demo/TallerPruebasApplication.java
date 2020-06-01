package com.example.demo;

import java.math.BigDecimal;

import javax.naming.Context;

import org.apache.catalina.core.ApplicationContext;
import org.apache.naming.ContextAccessController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.context.SpringContextUtils;

import com.example.demo.delegate.TsscStoryDelegate;
import com.example.demo.model.TsscAdmin;
import com.example.demo.model.TsscStory;
import com.example.demo.service.TsscAdminService;
import com.example.demo.service.TsscStoryService;

import lombok.extern.java.Log;

@Log
@SpringBootApplication
@EnableJpaRepositories("com.example.demo.repository")
@EntityScan("com.example.demo.model")
@ComponentScan({"com.example.demo"})
public class TallerPruebasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TallerPruebasApplication.class, args);

	}
	

	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
		
		
		
		
	
	
	@Bean
	public CommandLineRunner demo( TsscStoryDelegate delegate) {
		return (args) -> {

			
			
			
			TsscStory s = new TsscStory ();
			s.setDescription("LA DESCRIPCION");
			s.setBusinessValue(BigDecimal.valueOf(10));
			s.setPriority(BigDecimal.valueOf(30));
			s.setInitialSprint(BigDecimal.valueOf(50));
			delegate.save(s);
			
			
			
			
			
			
			
			

		};

	}
	
	
	

	
	

	
	
	
	
	
	
	
	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}
	

	
	

}
