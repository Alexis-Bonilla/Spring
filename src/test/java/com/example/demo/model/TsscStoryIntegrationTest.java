package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repository.TsscGameRepository;
import com.example.demo.repository.TsscStoryRepository;
import com.example.demo.service.TsscGameServiceImp;
import com.example.demo.service.TsscStoryServiceImp;

import lombok.extern.java.Log;
@SpringBootTest
@Log
class TsscStoryIntegrationTest {

	@Autowired
	private TsscStoryServiceImp storyService;

	@Autowired
	private TsscGameServiceImp gameService;
	
	@BeforeEach
	public void setUp(){

	}
	
	@DisplayName("ValorNegocio = 0 SprintInicial = 1 Prioridad =0")
    @Test
    public void test1() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(0));
        assertFalse(storyService.save(aux));
    
    }
	@DisplayName("ValorNegocio = 0 SprintInicial = -1 Prioridad =0")
    @Test
    public void test2() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(0));
        assertFalse(storyService.save(aux));
    
    }
	@DisplayName("ValorNegocio = 0 SprintInicial = 0 Prioridad =0")
    @Test
    public void test3() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(0));
        aux.setPriority(BigDecimal.valueOf(0));
        assertFalse(storyService.save(aux));
    
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 0 Prioridad =0")
    @Test
    public void test4() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(0));
        aux.setPriority(BigDecimal.valueOf(0));
        assertFalse(storyService.save(aux));
    
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = -1 Prioridad =0")
    @Test
    public void test5() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(0));
        assertFalse(storyService.save(aux));
    
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad =0")
    @Test
    public void test6() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(0));
        assertFalse(storyService.save(aux));
    
    }
	@DisplayName("ValorNegocio = -1 SprintInicial = -1 Prioridad =0")
    @Test
    public void test7() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(-1));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(0));
        assertFalse(storyService.save(aux));
    
    }
	@DisplayName("ValorNegocio = 0 SprintInicial = 1 Prioridad =1")
    @Test
    public void test8() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        assertFalse(storyService.save(aux));
    
    }
	@DisplayName("ValorNegocio = 0 SprintInicial = -1 Prioridad =1")
    @Test
    public void test9() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(1));
        assertFalse(storyService.save(aux));
    
    }
	@DisplayName("ValorNegocio = 0 SprintInicial = 0 Prioridad =1")
    @Test
    public void test10() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(0));
        aux.setPriority(BigDecimal.valueOf(1));
        assertFalse(storyService.save(aux));
    
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 0 Prioridad =1")
    @Test
    public void test11() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(0));
        aux.setPriority(BigDecimal.valueOf(1));
        assertFalse(storyService.save(aux));
    
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = -1 Prioridad =1")
    @Test
    public void test12() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(1));
        assertFalse(storyService.save(aux));
    
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad =1")
    @Test
    public void test13() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        assertTrue(storyService.save(aux));
    
    }
	@DisplayName("ValorNegocio = -1 SprintInicial = -1 Prioridad =1")
    @Test
    public void test14() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(-1));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(1));
        assertFalse(storyService.save(aux));
    
    }

	
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 0 SprintInicial =1 Prioridad = 0")
    @Test
    public void test15() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        assertTrue(storyService.save(aux));
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(0));
        assertFalse(storyService.save(aux));
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 0 SprintInicial =-1 Prioridad = 0")
    @Test
    public void test16() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        assertTrue(storyService.save(aux));
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(0));
        assertFalse(storyService.save(aux));
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 0 SprintInicial =0 Prioridad = 0")
    @Test
    public void test17() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        assertTrue(storyService.save(aux));
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(0));
        aux.setPriority(BigDecimal.valueOf(0));
        assertFalse(storyService.save(aux));
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 1 SprintInicial =0 Prioridad = 0")
    @Test
    public void test18() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        assertTrue(storyService.save(aux));
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(0));
        aux.setPriority(BigDecimal.valueOf(0));
        assertFalse(storyService.save(aux));
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 1 SprintInicial =-1 Prioridad = 0")
    @Test
    public void test19() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        assertTrue(storyService.save(aux));
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(0));
        assertFalse(storyService.save(aux));
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 1 SprintInicial =1 Prioridad = 0")
    @Test
    public void test20() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        assertTrue(storyService.save(aux));
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(0));
        assertFalse(storyService.save(aux));
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = -1 SprintInicial =-1 Prioridad = 0")
    @Test
    public void test21() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        assertTrue(storyService.save(aux));
        aux.setBusinessValue(BigDecimal.valueOf(-1));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(0));
        assertFalse(storyService.save(aux));
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 2 SprintInicial =2 Prioridad = 2")
    @Test
    public void test22() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        assertTrue(storyService.save(aux));
        aux.setBusinessValue(BigDecimal.valueOf(2));
        aux.setInitialSprint(BigDecimal.valueOf(2));
        aux.setPriority(BigDecimal.valueOf(2));
        assertTrue(storyService.save(aux));
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 0 SprintInicial =-1 Prioridad = 1")
    @Test
    public void test23() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        assertTrue(storyService.save(aux));
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(1));
        assertFalse(storyService.save(aux));
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 0 SprintInicial =0 Prioridad = 1")
    @Test
    public void test24() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        assertTrue(storyService.save(aux));
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(0));
        aux.setPriority(BigDecimal.valueOf(1));
        assertFalse(storyService.save(aux));
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 1 SprintInicial =0 Prioridad = 1")
    @Test
    public void test25() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        assertTrue(storyService.save(aux));
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(0));
        aux.setPriority(BigDecimal.valueOf(1));
        assertFalse(storyService.save(aux));
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 1 SprintInicial =-1 Prioridad = 1")
    @Test
    public void test26() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        assertTrue(storyService.save(aux));
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(1));
        assertFalse(storyService.save(aux));
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = 0 SprintInicial =1 Prioridad = 1")
    @Test
    public void test27() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        assertTrue(storyService.save(aux));
        aux.setBusinessValue(BigDecimal.valueOf(0));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        assertFalse(storyService.save(aux));
    }
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
	+ " luego cambian a ValorNegocio = -1 SprintInicial =-1 Prioridad = 1")
    @Test
    public void test28() {
        TsscStory aux = new TsscStory();
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));
        assertTrue(storyService.save(aux));
        aux.setBusinessValue(BigDecimal.valueOf(-1));
        aux.setInitialSprint(BigDecimal.valueOf(-1));
        aux.setPriority(BigDecimal.valueOf(1));
        assertFalse(storyService.save(aux));
    }
	
	@DisplayName("ValorNegocio = 1 SprintInicial = 1 Prioridad = 1,"
			+ " Game !=null pero no es un Game existente")
    @Test
    public void test29() {
		
        TsscStory aux = new TsscStory();
        TsscGame game = new TsscGame();
        game.setNGroups(1);
        game.setNSprints(1);
        game.setId(20451);
        gameService.save(game);
        TsscGame game2 = new TsscGame();
        game2.setId(1258);
        aux.setBusinessValue(BigDecimal.valueOf(1));
        aux.setInitialSprint(BigDecimal.valueOf(1));
        aux.setPriority(BigDecimal.valueOf(1));  
        aux.setTsscGame(game2);
        assertFalse(storyService.save(aux));
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
        game.setNGroups(1);
        game.setNSprints(1);
        game.setId(20451);
        gameService.save(game);
        TsscGame game2 = new TsscGame();
        game2.setId(20451);
        aux.setTsscGame(game2);
        assertTrue(storyService.save(aux));
    }


	

}
