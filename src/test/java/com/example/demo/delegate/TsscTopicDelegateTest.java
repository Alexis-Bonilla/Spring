package com.example.demo.delegate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.TsscTopic;
import com.example.demo.repository.TsscTopicRepository;


class TsscTopicDelegateTest {

	@InjectMocks
	private TsscTopicDelegate delegate;
	
	@Mock
	private RestTemplate restTemplate;
	
	
	@BeforeEach
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}
	
	@DisplayName("Sprints 0 grupos 1")
    @Test
    public void test1() {
        TsscTopic aux = new TsscTopic();
        aux.setDefaultSprints(0);
        aux.setDefaultGroups(1);
        delegate.save(aux);
        when(restTemplate.getForObject(delegate.getIdResources(), TsscTopic.class, aux.getId())).thenReturn(aux);
        assertFalse(delegate.findById(aux.getId())==null);
    
    }
	
	@DisplayName("Sprints 0 grupos -1")
    @Test
    public void test2() {
        TsscTopic aux = new TsscTopic();
        aux.setDefaultSprints(0);
        aux.setDefaultGroups(-1);
        delegate.save(aux);
        when(restTemplate.getForObject(delegate.getIdResources(), TsscTopic.class, aux.getId())).thenReturn(null);
        assertFalse(delegate.findById(aux.getId())!=null);
      
    }
	@DisplayName("Sprints 0 grupos 0")
    @Test
    public void test3() {
        TsscTopic aux = new TsscTopic();
        aux.setDefaultSprints(0);
        aux.setDefaultGroups(0);
        delegate.save(aux);
        when(restTemplate.getForObject(delegate.getIdResources(), TsscTopic.class, aux.getId())).thenReturn(aux);
        assertFalse(delegate.findById(aux.getId())==null);
  
    }
	
	@DisplayName("Sprints 1 grupos 0")
    @Test
    public void test4() {
        TsscTopic aux = new TsscTopic();
        aux.setDefaultSprints(1);
        aux.setDefaultGroups(0);
        delegate.save(aux);
        when(restTemplate.getForObject(delegate.getIdResources(), TsscTopic.class, aux.getId())).thenReturn(aux);
        assertFalse(delegate.findById(aux.getId())==null);
   
    }
	
	@DisplayName("Sprints 1 grupos -1")
    @Test
    public void test5() {
        TsscTopic aux = new TsscTopic();
        aux.setDefaultSprints(1);
        aux.setDefaultGroups(-1);
        delegate.save(aux);
        when(restTemplate.getForObject(delegate.getIdResources(), TsscTopic.class, aux.getId())).thenReturn(null);
        assertFalse(delegate.findById(aux.getId())!=null);
    
    }
	
	@DisplayName("Sprints 1 grupos 1")
    @Test
    public void test6() {
        TsscTopic aux = new TsscTopic();
        aux.setDefaultSprints(1);
        aux.setDefaultGroups(1);
        delegate.save(aux);
        when(restTemplate.getForObject(delegate.getIdResources(), TsscTopic.class, aux.getId())).thenReturn(aux);
        assertFalse(delegate.findById(aux.getId())==null);
    }
	
	@DisplayName("Sprints -1 grupos -1")
    @Test
    public void test7() {
        TsscTopic aux = new TsscTopic();
        aux.setDefaultSprints(-1);
        aux.setDefaultGroups(-1);
        delegate.save(aux);
        when(restTemplate.getForObject(delegate.getIdResources(), TsscTopic.class, aux.getId())).thenReturn(null);
        assertFalse(delegate.findById(aux.getId())!=null);
    
    }
	
	
	@DisplayName("Sprints = 1, grupos = 1, luego cambian a Sprints = 2, grupos = 2")
    @Test
    public void test8() {
        TsscTopic aux = new TsscTopic();
        aux.setDefaultSprints(1);
        aux.setDefaultGroups(1);
        delegate.save(aux);
        when(restTemplate.getForObject(delegate.getIdResources(), TsscTopic.class, aux.getId())).thenReturn(aux);
        assertFalse(delegate.findById(aux.getId())==null);
        aux.setDefaultSprints(2);
        aux.setDefaultGroups(2);
        delegate.save(aux);
        when(restTemplate.getForObject(delegate.getIdResources(), TsscTopic.class, aux.getId())).thenReturn(aux);
        assertFalse(delegate.findById(aux.getId())==null);
    }
	
	@DisplayName("Sprints = 1, grupos = 1, luego cambian a Sprints = 0, grupos = 1")
    @Test
    public void test9() {
        TsscTopic aux = new TsscTopic();
        aux.setDefaultSprints(1);
        aux.setDefaultGroups(1);
        delegate.save(aux);
        when(restTemplate.getForObject(delegate.getIdResources(), TsscTopic.class, aux.getId())).thenReturn(aux);
        assertFalse(delegate.findById(aux.getId())==null);
        aux.setDefaultSprints(0);
        aux.setDefaultGroups(1);
        delegate.save(aux);
        when(restTemplate.getForObject(delegate.getIdResources(), TsscTopic.class, aux.getId())).thenReturn(aux);
        assertFalse(delegate.findById(aux.getId())==null);
  
    }
	
	@DisplayName("Sprints = 1, grupos = 1, luego cambian a Sprints = 1, grupos = 0")
    @Test
    public void test10() {
        TsscTopic aux = new TsscTopic();
        aux.setDefaultSprints(1);
        aux.setDefaultGroups(1);
        delegate.save(aux);
        when(restTemplate.getForObject(delegate.getIdResources(), TsscTopic.class, aux.getId())).thenReturn(aux);
        assertFalse(delegate.findById(aux.getId())==null);
        aux.setDefaultSprints(1);
        aux.setDefaultGroups(0);
        delegate.save(aux);
        when(restTemplate.getForObject(delegate.getIdResources(), TsscTopic.class, aux.getId())).thenReturn(aux);
        assertFalse(delegate.findById(aux.getId())==null);
   
    }
	
	@DisplayName("Sprints = 1, grupos = 1, luego cambian a Sprints = 0, grupos = 0")
    @Test
    public void test11() {
        TsscTopic aux = new TsscTopic();
        aux.setDefaultSprints(1);
        aux.setDefaultGroups(1);
        delegate.save(aux);
        when(restTemplate.getForObject(delegate.getIdResources(), TsscTopic.class, aux.getId())).thenReturn(aux);
        assertFalse(delegate.findById(aux.getId())==null);
        aux.setDefaultSprints(0);
        aux.setDefaultGroups(0);
        delegate.save(aux);
        when(restTemplate.getForObject(delegate.getIdResources(), TsscTopic.class, aux.getId())).thenReturn(aux);
        assertFalse(delegate.findById(aux.getId())==null);
   
    }
	
	@DisplayName("Sprints = 1, grupos = 1, luego cambian a Sprints = -1, grupos = 0")
    @Test
    public void test12() {
        TsscTopic aux = new TsscTopic();
        aux.setDefaultSprints(1);
        aux.setDefaultGroups(1);
        delegate.save(aux);
        when(restTemplate.getForObject(delegate.getIdResources(), TsscTopic.class, aux.getId())).thenReturn(aux);
        assertFalse(delegate.findById(aux.getId())==null);
        aux.setDefaultSprints(-1);
        aux.setDefaultGroups(0);
        delegate.save(aux);
        when(restTemplate.getForObject(delegate.getIdResources(), TsscTopic.class, aux.getId())).thenReturn(aux);
        assertFalse(delegate.findById(aux.getId())==null);
    }
	
	@DisplayName("Sprints = 1, grupos = 1, luego cambian a Sprints = 0, grupos = -1")
    @Test
    public void test13() {
        TsscTopic aux = new TsscTopic();
        aux.setDefaultSprints(1);
        aux.setDefaultGroups(1);
        delegate.save(aux);
        when(restTemplate.getForObject(delegate.getIdResources(), TsscTopic.class, aux.getId())).thenReturn(aux);
        assertFalse(delegate.findById(aux.getId())==null);
        aux.setDefaultSprints(0);
        aux.setDefaultGroups(-1);
        delegate.save(aux);
        when(restTemplate.getForObject(delegate.getIdResources(), TsscTopic.class, aux.getId())).thenReturn(aux);
        assertFalse(delegate.findById(aux.getId())==null);

    }
	
	@DisplayName("Sprints = 1, grupos = 1, luego cambian a Sprints = -1, grupos = -1")
    @Test
    public void test14() {
        TsscTopic aux = new TsscTopic();
        aux.setDefaultSprints(1);
        aux.setDefaultGroups(1);
        delegate.save(aux);
        when(restTemplate.getForObject(delegate.getIdResources(), TsscTopic.class, aux.getId())).thenReturn(aux);
        assertFalse(delegate.findById(aux.getId())==null);
        aux.setDefaultSprints(-1);
        aux.setDefaultGroups(-1);
        delegate.save(aux);
        when(restTemplate.getForObject(delegate.getIdResources(), TsscTopic.class, aux.getId())).thenReturn(null);
        assertFalse(delegate.findById(aux.getId())!=null);

    }
	

	

}
