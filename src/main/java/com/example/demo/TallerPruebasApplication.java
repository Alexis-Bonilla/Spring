package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

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


import com.example.demo.dao.TsscGameDao;
import com.example.demo.dao.TsscGameDaoImp;
import com.example.demo.delegate.TsscStoryDelegate;
import com.example.demo.model.TsscAdmin;
import com.example.demo.model.TsscGame;
import com.example.demo.model.TsscStory;
import com.example.demo.model.TsscTopic;
import com.example.demo.service.TsscAdminService;
import com.example.demo.service.TsscAdminServiceImp;
import com.example.demo.service.TsscGameService;
import com.example.demo.service.TsscGameServiceImp;
import com.example.demo.service.TsscStoryService;
import com.example.demo.service.TsscStoryServiceImp;
import com.example.demo.service.TsscTopicService;
import com.example.demo.service.TsscTopicServiceImp;

import lombok.extern.java.Log;


@Log
@SpringBootApplication
public class TallerPruebasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TallerPruebasApplication.class, args);
		//ConfigurableApplicationContext c = SpringApplication.run(TallerPruebasApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	

	
	@Bean
	public CommandLineRunner demo(TsscAdminService adminServiceImp, TsscTopicService topicServiceImp,
			TsscGameService gameServiceImp, TsscStoryService storyServiceImp) {
		return (args) -> {

			TsscAdmin user = new TsscAdmin();
			user.setUser("Alexis");
			user.setPassword("{noop}123");
			user.setSuperAdmin("superAdministrator");
			adminServiceImp.save(user);
			
			user = new TsscAdmin();
			user.setSuperAdmin("administrator");
			user.setUser("admin");
			user.setPassword("{noop}123");
			adminServiceImp.save(user);
			
			TsscTopic topic= new TsscTopic();
			topic.setName("MOBA");
			topic.setDescription("Kind of game 5v5");
			topic.setDefaultGroups(5);
			topic.setDefaultSprints(5);
			topic.setGroupPrefix("100-Groups");
			
			TsscStory story = new TsscStory();
			story.setShortDescription("Flamer");
			story.setPriority(BigDecimal.TEN);
			story.setBusinessValue(BigDecimal.TEN);
			story.setInitialSprint(BigDecimal.ONE);
			story.setTsscTopic(topic);
			
			TsscGame game = new TsscGame();
			game.setName("LOL");
			game.setNGroups(5);
			game.setNSprints(5);
			game.setAdminPassword("123");
			game.setGuestPassword("123");
			game.setScheduledTime(LocalTime.MIDNIGHT);
			game.setScheduledDate(LocalDate.of(2020, 7, 25));
			game.setStartTime(LocalTime.NOON);
			game.setTsscTopic(topic);
			ArrayList<TsscGame> games = new ArrayList<>();
			games.add(game);
			
			topicServiceImp.save(topic);
			game.setTsscTopic(topic);
			gameServiceImp.save(game);
			story.setTsscGame(game);
			story.setTsscTopic(topic);
			storyServiceImp.save(story);
			
			
			
			
			
			

		};

	}
	

	
	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}
	

	
	

}
