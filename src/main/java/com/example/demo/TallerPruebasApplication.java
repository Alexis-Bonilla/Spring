package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import com.example.demo.model.TsscAdmin;
import com.example.demo.service.TsscAdminService;

import lombok.extern.java.Log;

@Log
@SpringBootApplication
public class TallerPruebasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TallerPruebasApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(TsscAdminService tssAdminService) {
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

		};

	}
	
	
	
	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}
	

	
	

}
