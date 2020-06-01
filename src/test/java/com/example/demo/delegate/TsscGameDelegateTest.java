package com.example.demo.delegate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.TsscGame;
import com.example.demo.model.TsscTopic;
import com.example.demo.repository.TsscGameRepository;
import com.example.demo.repository.TsscTopicRepository;
import com.example.demo.service.TsscGameServiceImp;

class TsscGameDelegateTest {

	@InjectMocks
	private TsscGameDelegate gameDelegate;

	
	@Mock
	private RestTemplate restTemplate;
	
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
        gameDelegate.save(aux);
        when(restTemplate.getForObject(gameDelegate.getIdResource(), TsscGame.class, aux.getId())).thenReturn(null);
        assertTrue(gameDelegate.findById(aux.getId())==null);
    
    }
	
	@DisplayName("Sprints 0 grupos -1")
    @Test
    public void test2() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(0);
        aux.setNGroups(-1);
        gameDelegate.save(aux);
        when(restTemplate.getForObject(gameDelegate.getIdResource(), TsscGame.class, aux.getId())).thenReturn(null);
        assertTrue(gameDelegate.findById(aux.getId())==null);
      
    }
	@DisplayName("Sprints 0 grupos 0")
    @Test
    public void test3() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(0);
        aux.setNGroups(0);
        gameDelegate.save(aux);
        when(restTemplate.getForObject(gameDelegate.getIdResource(), TsscGame.class, aux.getId())).thenReturn(null);
        assertTrue(gameDelegate.findById(aux.getId())==null);
  
    }
	
	@DisplayName("Sprints 1 grupos 0")
    @Test
    public void test4() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(1);
        aux.setNGroups(0);
        gameDelegate.save(aux);
        when(restTemplate.getForObject(gameDelegate.getIdResource(), TsscGame.class, aux.getId())).thenReturn(null);
        assertTrue(gameDelegate.findById(aux.getId())==null);
    }
	
	@DisplayName("Sprints 1 grupos -1")
    @Test
    public void test5() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(1);
        aux.setNGroups(-1);
        gameDelegate.save(aux);
        when(restTemplate.getForObject(gameDelegate.getIdResource(), TsscGame.class, aux.getId())).thenReturn(null);
        assertTrue(gameDelegate.findById(aux.getId())==null);
    }
	
	@DisplayName("Sprints 1 grupos 1")
    @Test
    public void test6() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(1);
        aux.setNGroups(1);
        gameDelegate.save(aux);
        when(restTemplate.getForObject(gameDelegate.getIdResource(), TsscGame.class, aux.getId())).thenReturn(null);
        assertTrue(gameDelegate.findById(aux.getId())==null);
    }
	
	@DisplayName("Sprints -1 grupos -1")
    @Test
    public void test7() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(-1);
        aux.setNGroups(-1);
        gameDelegate.save(aux);
        when(restTemplate.getForObject(gameDelegate.getIdResource(), TsscGame.class, aux.getId())).thenReturn(null);
        assertTrue(gameDelegate.findById(aux.getId())==null);
    }
	
	
	@DisplayName("Sprints = 1, grupos = 1, luego cambian a Sprints = 2, grupos = 2")
    @Test
    public void test8() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(1);
        aux.setNGroups(1);
        gameDelegate.save(aux);
        when(restTemplate.getForObject(gameDelegate.getIdResource(), TsscGame.class, aux.getId())).thenReturn(null);
        assertTrue(gameDelegate.findById(aux.getId())==null);
        aux.setNSprints(2);
        aux.setNGroups(2);
        gameDelegate.save(aux);
        when(restTemplate.getForObject(gameDelegate.getIdResource(), TsscGame.class, aux.getId())).thenReturn(null);
        assertTrue(gameDelegate.findById(aux.getId())==null);    }
	
	@DisplayName("Sprints = 1, grupos = 1, luego cambian a Sprints = 0, grupos = 1")
    @Test
    public void test9() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(1);
        aux.setNGroups(1);
        gameDelegate.save(aux);
        when(restTemplate.getForObject(gameDelegate.getIdResource(), TsscGame.class, aux.getId())).thenReturn(aux);
        assertTrue(gameDelegate.findById(aux.getId())!=null);
        aux.setNSprints(0);
        aux.setNGroups(1);
        gameDelegate.save(aux);
        when(restTemplate.getForObject(gameDelegate.getIdResource(), TsscGame.class, aux.getId())).thenReturn(null);
        assertTrue(gameDelegate.findById(aux.getId())==null);
  
    }
	
	@DisplayName("Sprints = 1, grupos = 1, luego cambian a Sprints = 1, grupos = 0")
    @Test
    public void test10() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(1);
        aux.setNGroups(1);
        gameDelegate.save(aux);
        when(restTemplate.getForObject(gameDelegate.getIdResource(), TsscGame.class, aux.getId())).thenReturn(aux);
        assertTrue(gameDelegate.findById(aux.getId())!=null);
        aux.setNSprints(1);
        aux.setNGroups(0);
        gameDelegate.save(aux);
        when(restTemplate.getForObject(gameDelegate.getIdResource(), TsscGame.class, aux.getId())).thenReturn(null);
        assertTrue(gameDelegate.findById(aux.getId())==null);
   
    }
	
	@DisplayName("Sprints = 1, grupos = 1, luego cambian a Sprints = 0, grupos = 0")
    @Test
    public void test11() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(1);
        aux.setNGroups(1);
        gameDelegate.save(aux);
        when(restTemplate.getForObject(gameDelegate.getIdResource(), TsscGame.class, aux.getId())).thenReturn(aux);
        assertTrue(gameDelegate.findById(aux.getId())!=null);
        aux.setNSprints(0);
        aux.setNGroups(0);
        gameDelegate.save(aux);
        when(restTemplate.getForObject(gameDelegate.getIdResource(), TsscGame.class, aux.getId())).thenReturn(null);
        assertTrue(gameDelegate.findById(aux.getId())==null);
   
    }
	
	@DisplayName("Sprints = 1, grupos = 1, luego cambian a Sprints = -1, grupos = 0")
    @Test
    public void test12() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(1);
        aux.setNGroups(1);
        gameDelegate.save(aux);
        when(restTemplate.getForObject(gameDelegate.getIdResource(), TsscGame.class, aux.getId())).thenReturn(aux);
        assertTrue(gameDelegate.findById(aux.getId())!=null);
        aux.setNSprints(-1);
        aux.setNGroups(0);
        gameDelegate.save(aux);
        when(restTemplate.getForObject(gameDelegate.getIdResource(), TsscGame.class, aux.getId())).thenReturn(null);
        assertTrue(gameDelegate.findById(aux.getId())==null);

    }
	
	@DisplayName("Sprints = 1, grupos = 1, luego cambian a Sprints = 0, grupos = -1")
    @Test
    public void test13() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(1);
        aux.setNGroups(1);
        gameDelegate.save(aux);
        when(restTemplate.getForObject(gameDelegate.getIdResource(), TsscGame.class, aux.getId())).thenReturn(aux);
        assertTrue(gameDelegate.findById(aux.getId())!=null);
        aux.setNSprints(0);
        aux.setNGroups(-1);
        gameDelegate.save(aux);
        when(restTemplate.getForObject(gameDelegate.getIdResource(), TsscGame.class, aux.getId())).thenReturn(null);
        assertTrue(gameDelegate.findById(aux.getId())==null);

    }
	
	@DisplayName("Sprints = 1, grupos = 1, luego cambian a Sprints = -1, grupos = -1")
    @Test
    public void test14() {
        TsscGame aux = new TsscGame();
        aux.setNSprints(1);
        aux.setNGroups(1);
        gameDelegate.save(aux);
        when(restTemplate.getForObject(gameDelegate.getIdResource(), TsscGame.class, aux.getId())).thenReturn(aux);
        assertTrue(gameDelegate.findById(aux.getId())!=null);
        aux.setNSprints(-1);
        aux.setNGroups(-1);
        gameDelegate.save(aux);
        when(restTemplate.getForObject(gameDelegate.getIdResource(), TsscGame.class, aux.getId())).thenReturn(null);
        assertTrue(gameDelegate.findById(aux.getId())==null);

    }
	
	@DisplayName("Sprints = 1, grupos = 1, Topic !=null pero no es un topic existente")
    @Test
    public void test15() {
        TsscGame aux = new TsscGame();
        TsscTopic topicAux = new TsscTopic();
        topicAux.setId(4);
        aux.setTsscTopic(topicAux);
        gameDelegate.save(aux);
        when(restTemplate.getForObject(gameDelegate.getIdResource(), TsscGame.class, aux.getId())).thenReturn(null);

        TsscTopic topicAux1 = new TsscTopic();
        topicAux1.setId(4);
        aux.setNSprints(1);
        aux.setNGroups(1);
        aux.setTsscTopic(topicAux1);
        assertTrue(gameDelegate.findById(aux.getId())==null);

    }
	
	@DisplayName("Sprints = 1, grupos = 1, Topic !=null  y existente")
    @Test
    public void test16() {
        TsscGame aux = new TsscGame();
        TsscTopic topicAux = new TsscTopic();
        topicAux.setId(4);
        aux.setTsscTopic(topicAux);
        gameDelegate.save(aux);
        when(restTemplate.getForObject(gameDelegate.getIdResource(), TsscGame.class, aux.getId())).thenReturn(aux);
        TsscTopic topicAux1 = new TsscTopic();
        topicAux1.setId(4);
        aux.setNSprints(1);
        aux.setNGroups(1);
        aux.setTsscTopic(topicAux1);
        assertTrue(gameDelegate.findById(aux.getId())!=null);

    }
	
	
}
