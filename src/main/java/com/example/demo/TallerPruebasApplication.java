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
	public CommandLineRunner demo(TsscAdminService tssAdminService, TsscStoryService service) {
		return (args) -> {
			TsscAdmin user = new TsscAdmin();
			user.setUser("Alexis");
			user.setPassword("{noop}123");
			user.setSuperAdmin("superAdministrator");
			log.info("SE ESTÁ EJECUTANDO");
			tssAdminService.save(user);
			
			
			
			

			TsscAdmin user2 = new TsscAdmin();
			user2.setUser("Bonilla");
			user2.setPassword("{noop}123");
			user2.setSuperAdmin("administrator");
			tssAdminService.save(user2);
			
			
			
			TsscStory s = new TsscStory ();
			s.setDescription("LA DESCRIPCION");
			s.setBusinessValue(BigDecimal.valueOf(10));
			s.setPriority(BigDecimal.valueOf(30));
			s.setInitialSprint(BigDecimal.valueOf(50));
			service.save(s);
			
			
			
			
			
			
			
			

		};

	}
	
	
	
	/*@Bean
	public CommandLineRunner demo1( TsscStoryService service) {
		return (args) -> {

			
			TsscStory s = new TsscStory ();
			s.setAltDescripton("Alt Desrip");
			s.setBusinessValue(BigDecimal.valueOf(40));
			s.setDescription("lA DESCRIPTCION");
			service.save(s);
		};

	}*/
	
	

	
	
	
	
	
	
	
	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}
	

	
	

}
