package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.TsscGameServiceImp;
import com.example.demo.service.TsscTopicServiceImp;
@SpringBootTest
class TsscGame2IntegrationTest {


	@Autowired
	private TsscGameServiceImp gameService;
	@Autowired
	private TsscTopicServiceImp topicService;


	
	@BeforeEach
	public void setUp(){

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
        TsscTopic topicAux1 = new TsscTopic();
        topicAux1.setId(5);
        topicAux1.setDefaultGroups(1);
        topicAux1.setDefaultSprints(1);
        topicService.save(topicAux1);
        aux.setNSprints(1);
        aux.setNGroups(1);
        assertFalse(gameService.save(aux));

    }
	
	@DisplayName("Sprints = 1, grupos = 1, Topic !=null  y existente")
    @Test
    public void test16() {
        TsscGame aux = new TsscGame();
        TsscTopic topicAux = new TsscTopic();
        topicAux.setId(4);
        aux.setTsscTopic(topicAux);
        TsscTopic topicAux1 = new TsscTopic();
        topicAux1.setId(4);
        topicAux1.setDefaultGroups(1);
        topicAux1.setDefaultSprints(1);
        topicService.save(topicAux1);
        aux.setNSprints(1);
        aux.setNGroups(1);
        assertFalse(gameService.save(aux));

    }
	
	
	
	@DisplayName("Valida que la lista de Objetos TimeControl sean las mismas")
	public void test17() {
		long id = 1;
		TsscTimecontrol timecontrolOne = new TsscTimecontrol();
		TsscTimecontrol timecontrolTwo = new TsscTimecontrol();
		TsscTimecontrol timecontrolThree = new TsscTimecontrol();
		TsscTopic topic = new TsscTopic();
		topic.setDefaultGroups(1);
		topic.setDefaultSprints(1);
		topic.addTsscTimecontrol(timecontrolOne);
		topic.addTsscTimecontrol(timecontrolTwo);
		topic.addTsscTimecontrol(timecontrolThree);
		topicService.save(topic);
		topic.setId(id);

		TsscGame aux = new TsscGame();
		aux.setNGroups(1);
		aux.setNSprints(1);
		aux.setTsscTopic(topic);
		List<TsscTimecontrol> listTimecontrol = aux.getTsscTopic().getTsscTimecontrols();
		assertTrue(gameService.save2(aux, id));
		assertTrue(aux.getTsscTimecontrols().contains(timecontrolOne));
		assertTrue(aux.getTsscTimecontrols().contains(timecontrolTwo));
		assertTrue(aux.getTsscTimecontrols().contains(timecontrolThree));
	}
	
	@DisplayName("Valida que la lista de Objetos TimeControl sean las mismas")
	@Test
	public void test18() {
		long id = 1;
		TsscStory storyOne = new TsscStory();
		TsscStory storyTwo = new TsscStory();
		TsscStory storyThree = new TsscStory();
		TsscTopic topic = new TsscTopic();
		topic.setDefaultGroups(1);
		topic.setDefaultSprints(1);
		topic.addTsscStory(storyOne);
		topic.addTsscStory(storyTwo);
		topic.addTsscStory(storyThree);
		topicService.save(topic);
		topic.setId(id);
		TsscGame aux = new TsscGame();
		aux.setNGroups(1);
		aux.setNSprints(1);
		aux.setTsscTopic(topic);
		List<TsscStory> listStory = aux.getTsscTopic().getTsscStories();
		assertTrue(gameService.save2(aux, id));
		assertTrue(aux.getTsscStories().contains(storyOne));
		assertTrue(aux.getTsscStories().contains(storyTwo));
		assertTrue(aux.getTsscStories().contains(storyThree));
	}
	
	@DisplayName("Valida que ambas listas de Objetos TimeControl, y Story sean las mismas")
	@Test
	public void test19() {
		long id = 1;
		TsscStory storyOne = new TsscStory();
		TsscStory storyTwo = new TsscStory();
		TsscStory storyThree = new TsscStory();
		TsscTimecontrol timecontrolOne = new TsscTimecontrol();
		TsscTimecontrol timecontrolTwo = new TsscTimecontrol();
		TsscTimecontrol timecontrolThree = new TsscTimecontrol();
		TsscTopic topic = new TsscTopic();
		topic.setDefaultGroups(1);
		topic.setDefaultSprints(1);
		topic.addTsscStory(storyOne);
		topic.addTsscStory(storyTwo);
		topic.addTsscStory(storyThree);
		topic.addTsscTimecontrol(timecontrolOne);
		topic.addTsscTimecontrol(timecontrolTwo);
		topic.addTsscTimecontrol(timecontrolThree);
		topicService.save(topic);
		topic.setId(id);
		TsscGame aux = new TsscGame();
		aux.setNGroups(1);
		aux.setNSprints(1);
		aux.setTsscTopic(topic);
		List<TsscTimecontrol> listTimecontrol = aux.getTsscTopic().getTsscTimecontrols();
		List<TsscStory> listStory = aux.getTsscTopic().getTsscStories();
		assertTrue(gameService.save2(aux, id));
		assertTrue(aux.getTsscStories().contains(storyOne));
		assertTrue(aux.getTsscStories().contains(storyTwo));
		assertTrue(aux.getTsscStories().contains(storyThree));
		assertTrue(aux.getTsscTimecontrols().contains(timecontrolOne));
		assertTrue(aux.getTsscTimecontrols().contains(timecontrolTwo));
		assertTrue(aux.getTsscTimecontrols().contains(timecontrolThree));
	}
	
	
	
	
	

}
