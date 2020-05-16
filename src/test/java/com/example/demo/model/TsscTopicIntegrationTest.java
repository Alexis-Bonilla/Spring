package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.example.demo.service.TsscTopicService;
import com.example.demo.service.TsscTopicServiceImp;

import lombok.extern.java.Log;


@SpringBootTest
@Log
class TsscTopicIntegrationTest {

	
	
	
	@Autowired
	TsscTopicServiceImp service;
	
	@BeforeEach
	public void setUp(){
		service.clearTopics();
	}
	
	
	@DisplayName("Sprints 0 grupos 1")
    @Test
    public void test1() {
        TsscTopic aux = new TsscTopic();
        aux.setDefaultSprints(0);
        aux.setDefaultGroups(1);
        assertFalse(service.save(aux));
    
    }
	
	@DisplayName("Sprints 0 grupos -1")
    @Test
    public void test2() {
        TsscTopic aux = new TsscTopic();
        aux.setDefaultSprints(0);
        aux.setDefaultGroups(-1);
        assertFalse(service.save(aux));
      
    }
	@DisplayName("Sprints 0 grupos 0")
    @Test
    public void test3() {
        TsscTopic aux = new TsscTopic();
        aux.setDefaultSprints(0);
        aux.setDefaultGroups(0);
        assertFalse(service.save(aux));
  
    }
	
	@DisplayName("Sprints 1 grupos 0")
    @Test
    public void test4() {
        TsscTopic aux = new TsscTopic();
        aux.setDefaultSprints(1);
        aux.setDefaultGroups(0);
        assertFalse(service.save(aux));
   
    }
	
	@DisplayName("Sprints 1 grupos -1")
    @Test
    public void test5() {
        TsscTopic aux = new TsscTopic();
        aux.setDefaultSprints(1);
        aux.setDefaultGroups(-1);
        assertFalse(service.save(aux));
    
    }
	
	@DisplayName("Sprints 1 grupos 1")
    @Test
    public void test6() {
        TsscTopic aux = new TsscTopic();
        aux.setDefaultSprints(1);
        aux.setDefaultGroups(1);
        assertTrue(service.save(aux));
    }
	
	@DisplayName("Sprints -1 grupos -1")
    @Test
    public void test7() {
        TsscTopic aux = new TsscTopic();
        aux.setDefaultSprints(-1);
        aux.setDefaultGroups(-1);
        assertFalse(service.save(aux));
    
    }
	
	
	@DisplayName("Topic de id = 1, Sprints=1, Groups = 1, se edita defaultSprints = -1")
    @Test
    public void test8() {
        TsscTopic aux = new TsscTopic();
        aux.setId(1);
        aux.setDefaultSprints(1);
        aux.setDefaultGroups(1);
        assertTrue(service.save(aux));
        assertFalse(service.updateDefaultSprints(aux.getId(), -1));    
    }
	
	@DisplayName("Topic de id = 1, Sprints=1, Groups = 1, se edita defaultSprints = 0")
    @Test
    public void test9() {
        TsscTopic aux = new TsscTopic();
        aux.setId(1);
        aux.setDefaultSprints(1);
        aux.setDefaultGroups(1);
        assertTrue(service.save(aux));
        assertFalse(service.updateDefaultSprints(aux.getId(), 0));    
    }
	@DisplayName("Topic de id = 1, Sprints=1,Groups = 1, se edita defaultSprints = 2")
    @Test
    public void test10() {
        TsscTopic aux = new TsscTopic();
        aux.setId(1);
        aux.setDefaultSprints(1);
        aux.setDefaultGroups(1);
        assertTrue(service.save(aux));
        assertTrue(service.updateDefaultSprints(aux.getId(), 2));    
    }
	
	@DisplayName("Topic de id = 1, Sprints = 1, Groups=1, se edita defaultGroups = -1")
    @Test
    public void test11() {
        TsscTopic aux = new TsscTopic();
        aux.setId(1);
        aux.setDefaultSprints(1);
        aux.setDefaultGroups(1);
        assertTrue(service.save(aux));
        assertFalse(service.updateDefaultGroups(aux.getId(),-1));    
    }
	@DisplayName("Topic de id = 1, Sprints = 1, Groups=1, se edita defaultGroups = 0")
    @Test
    public void test12() {
        TsscTopic aux = new TsscTopic();
        aux.setId(1);
        aux.setDefaultSprints(1);
        aux.setDefaultGroups(1);
        assertTrue(service.save(aux));
        assertFalse(service.updateDefaultGroups(aux.getId(), 0));    
    
    }
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	

}
