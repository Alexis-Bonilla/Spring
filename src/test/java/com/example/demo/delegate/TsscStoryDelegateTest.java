package com.example.demo.delegate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.TsscGame;
import com.example.demo.model.TsscStory;
import com.example.demo.repository.TsscGameRepository;
import com.example.demo.service.TsscStoryServiceImp;

class TsscStoryDelegateTest {

	@InjectMocks
	private TsscStoryDelegate storyDelegate;
	
	@Mock
	private RestTemplate template;
	
	@BeforeEach
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}
	
	@DisplayName("ValorNegocio = 0 SprintInicial = 1 Prioridad =0")
    @Test
    public void test1() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(0));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    
    }
	@DisplayName("ValorNegocio = 0 SprintInicial = -1 Prioridad =0")
    @Test
    public void test2() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(0));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    
    }
	@DisplayName("ValorNegocio = 0 SprintInicial = 0 Prioridad =0")
    @Test
    public void test3() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(0));
        aux.setPriority(BigDecimal.valueOf(0));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 0 Prioridad =0")
    @Test
    public void test4() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(0));
        aux.setPriority(BigDecimal.valueOf(0));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = -1 Prioridad =0")
    @Test
    public void test5() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(0));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad =0")
    @Test
    public void test6() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(0));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    
    }
	@DisplayName("ValorNegocio = -1 SprintInicial = -1 Prioridad =0")
    @Test
    public void test7() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(-1));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(0));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    
    }
	@DisplayName("ValorNegocio = 0 SprintInicial = 1 Prioridad =1")
    @Test
    public void test8() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    
    }
	@DisplayName("ValorNegocio = 0 SprintInicial = -1 Prioridad =1")
    @Test
    public void test9() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    
    }
	@DisplayName("ValorNegocio = 0 SprintInicial = 0 Prioridad =1")
    @Test
    public void test10() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(0));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 0 Prioridad =1")
    @Test
    public void test11() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(0));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = -1 Prioridad =1")
    @Test
    public void test12() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad =1")
    @Test
    public void test13() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    
    }
	@DisplayName("ValorNegocio = -1 SprintInicial = -1 Prioridad =1")
    @Test
    public void test14() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(-1));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    
    }

	
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 0 SprintInicial =1 Prioridad = 0")
    @Test
    public void test15() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(aux);
        assertTrue(storyDelegate.findById(aux.getId())!=null);
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(0));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 0 SprintInicial =-1 Prioridad = 0")
    @Test
    public void test16() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(aux);
        assertTrue(storyDelegate.findById(aux.getId())!=null);
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(0));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 0 SprintInicial =0 Prioridad = 0")
    @Test
    public void test17() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(aux);
        assertTrue(storyDelegate.findById(aux.getId())!=null);
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(0));
        aux.setPriority(BigDecimal.valueOf(0));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 1 SprintInicial =0 Prioridad = 0")
    @Test
    public void test18() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(aux);
        assertTrue(storyDelegate.findById(aux.getId())!=null);
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(0));
        aux.setPriority(BigDecimal.valueOf(0));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 1 SprintInicial =-1 Prioridad = 0")
    @Test
    public void test19() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(aux);
        assertTrue(storyDelegate.findById(aux.getId())!=null);
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(0));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 1 SprintInicial =1 Prioridad = 0")
    @Test
    public void test20() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(aux);
        assertTrue(storyDelegate.findById(aux.getId())!=null);
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(0));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = -1 SprintInicial =-1 Prioridad = 0")
    @Test
    public void test21() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(aux);
        assertTrue(storyDelegate.findById(aux.getId())!=null);
        aux.setBusinessValue(BigDecimal.valueOf(-1));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(0));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 2 SprintInicial =2 Prioridad = 2")
    @Test
    public void test22() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(aux);
        assertTrue(storyDelegate.findById(aux.getId())!=null);
        aux.setBusinessValue(BigDecimal.valueOf(2));
        aux.setInitialSprint(BigDecimal.valueOf(2));
        aux.setPriority(BigDecimal.valueOf(2));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(aux);
        assertTrue(storyDelegate.findById(aux.getId())!=null);
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 0 SprintInicial =-1 Prioridad = 1")
    @Test
    public void test23() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(aux);
        assertTrue(storyDelegate.findById(aux.getId())!=null);
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 0 SprintInicial =0 Prioridad = 1")
    @Test
    public void test24() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(aux);
        assertTrue(storyDelegate.findById(aux.getId())!=null);
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(0));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 1 SprintInicial =0 Prioridad = 1")
    @Test
    public void test25() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(aux);
        assertTrue(storyDelegate.findById(aux.getId())!=null);
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(0));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 1 SprintInicial =-1 Prioridad = 1")
    @Test
    public void test26() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(aux);
        assertTrue(storyDelegate.findById(aux.getId())!=null);
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 0 SprintInicial =1 Prioridad = 1")
    @Test
    public void test27() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(aux);
        assertTrue(storyDelegate.findById(aux.getId())!=null);
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = -1 SprintInicial =-1 Prioridad = 1")
    @Test
    public void test28() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(aux);
        assertTrue(storyDelegate.findById(aux.getId())!=null);
        aux.setBusinessValue(BigDecimal.valueOf(-1));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(1));
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    }
	
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
			+ " Game !=null pero no es un Game existente")
    @Test
    public void test29() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        TsscGame game = new TsscGame();
        aux.setTsscGame(game);
        aux.getTsscGame().setId(1);
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    }
	
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
			+ " Game !=null y existente")
    @Test
    public void test30() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        TsscGame game = new TsscGame();
        aux.setTsscGame(game);
        aux.getTsscGame().setId(1);
        storyDelegate.save(aux);
        when(template.getForObject(storyDelegate.getIdResource(), TsscStory.class, aux.getId())).thenReturn(null);
        assertTrue(storyDelegate.findById(aux.getId())==null);
    }


}
