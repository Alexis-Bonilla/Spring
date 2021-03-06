package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.TsscGame;
import com.example.demo.model.TsscTopic;
import com.example.demo.repository.TsscGameRepository;
import com.example.demo.repository.TsscTopicRepository;
@SpringBootTest
class TsscGameServiceTest {
	

	@InjectMocks
	private TsscGameServiceImp gameService;

	
	@Mock
	private TsscGameRepository repository;
	@Mock
	private TsscTopicRepository topicRepository;
	
	@BeforeEach
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}
	
	@DisplayName("Sprints 0 grupos 1")
    @Test
    public void test1() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(0);
        aux.setNGroups(1);
        assertFalse(gameService.save(aux));
    
    }
	
	@DisplayName("Sprints 0 grupos -1")
    @Test
    public void test2() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(0);
        aux.setNGroups(-1);
        assertFalse(gameService.save(aux));
      
    }
	@DisplayName("Sprints 0 grupos 0")
    @Test
    public void test3() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(0);
        aux.setNGroups(0);
        assertFalse(gameService.save(aux));
  
    }
	
	@DisplayName("Sprints 1 grupos 0")
    @Test
    public void test4() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(1);
        aux.setNGroups(0);
        assertFalse(gameService.save(aux));
   
    }
	
	@DisplayName("Sprints 1 grupos -1")
    @Test
    public void test5() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(1);
        aux.setNGroups(-1);
        assertFalse(gameService.save(aux));
    
    }
	
	@DisplayName("Sprints 1 grupos 1")
    @Test
    public void test6() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(1);
        aux.setNGroups(1);
        assertTrue(gameService.save(aux));
    }
	
	@DisplayName("Sprints -1 grupos -1")
    @Test
    public void test7() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(-1);
        aux.setNGroups(-1);
        assertFalse(gameService.save(aux));
    
    }
	
	
	@DisplayName("Sprints = 1, grupos = 1, luego cambian a Sprints = 2, grupos = 2")
    @Test
    public void test8() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(1);
        aux.setNGroups(1);
        assertTrue(gameService.save(aux));
        aux.setNSprints(2);
        aux.setNGroups(2);
        assertTrue(gameService.save(aux));
    }
	
	@DisplayName("Sprints = 1, grupos = 1, luego cambian a Sprints = 0, grupos = 1")
    @Test
    public void test9() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(1);
        aux.setNGroups(1);
        assertTrue(gameService.save(aux));
        aux.setNSprints(0);
        aux.setNGroups(1);
        assertFalse(gameService.save(aux));
  
    }
	
	@DisplayName("Sprints = 1, grupos = 1, luego cambian a Sprints = 1, grupos = 0")
    @Test
    public void test10() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(1);
        aux.setNGroups(1);
        assertTrue(gameService.save(aux));
        aux.setNSprints(1);
        aux.setNGroups(0);
        assertFalse(gameService.save(aux));
   
    }
	
	@DisplayName("Sprints = 1, grupos = 1, luego cambian a Sprints = 0, grupos = 0")
    @Test
    public void test11() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(1);
        aux.setNGroups(1);
        assertTrue(gameService.save(aux));
        aux.setNSprints(0);
        aux.setNGroups(0);
        assertFalse(gameService.save(aux));
   
    }
	
	@DisplayName("Sprints = 1, grupos = 1, luego cambian a Sprints = -1, grupos = 0")
    @Test
    public void test12() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(1);
        aux.setNGroups(1);
        assertTrue(gameService.save(aux));
        aux.setNSprints(-1);
        aux.setNGroups(0);
        assertFalse(gameService.save(aux));

    }
	
	@DisplayName("Sprints = 1, grupos = 1, luego cambian a Sprints = 0, grupos = -1")
    @Test
    public void test13() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(1);
        aux.setNGroups(1);
        assertTrue(gameService.save(aux));
        aux.setNSprints(0);
        aux.setNGroups(-1);
        assertFalse(gameService.save(aux));

    }
	
	@DisplayName("Sprints = 1, grupos = 1, luego cambian a Sprints = -1, grupos = -1")
    @Test
    public void test14() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(1);
        aux.setNGroups(1);
        assertTrue(gameService.save(aux));
        aux.setNSprints(-1);
        aux.setNGroups(-1);
        assertFalse(gameService.save(aux));

    }
	
	@DisplayName("Sprints = 1, grupos = 1, Topic !=null pero no es un topic existente")
    @Test
    public void test15() {
        TsscGame aux = new TsscGame();
        TsscTopic topicAux = new TsscTopic();
        topicAux.setId(4);
        aux.setTsscTopic(topicAux);
        when(topicRepository.existsById(aux.getTsscTopic().getId())).thenReturn(false);
        TsscTopic topicAux1 = new TsscTopic();
        topicAux1.setId(4);
        aux.setNSprints(1);
        aux.setNGroups(1);
        aux.setTsscTopic(topicAux1);
        assertFalse(gameService.save(aux));

    }
	
	@DisplayName("Sprints = 1, grupos = 1, Topic !=null  y existente")
    @Test
    public void test16() {
        TsscGame aux = new TsscGame();
        TsscTopic topicAux = new TsscTopic();
        topicAux.setId(4);
        aux.setTsscTopic(topicAux);
        when(topicRepository.existsById(aux.getTsscTopic().getId())).thenReturn(true);
        TsscTopic topicAux1 = new TsscTopic();
        topicAux1.setId(4);
        aux.setNSprints(1);
        aux.setNGroups(1);
        aux.setTsscTopic(topicAux1);
        assertTrue(gameService.save(aux));

    }
	
	

	
	
	
	
	
	
	
}
