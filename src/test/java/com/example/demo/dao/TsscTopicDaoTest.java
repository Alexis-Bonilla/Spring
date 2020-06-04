package com.example.demo.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.TallerPruebasApplication;
import com.example.demo.model.TsscGame;
import com.example.demo.model.TsscTopic;


@SpringBootTest(classes = TallerPruebasApplication.class)
@Rollback(false)
@ExtendWith(SpringExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class TsscTopicDaoTest {
	
	@Autowired
	TsscTopicDao topicDao ;
	
	@Autowired
	TsscGameDao gameDao ;

	@BeforeEach
	void setUp() throws Exception {
		//topicDao.deleteAll();
	}
	
    @AfterEach
    void afterEach() throws Exception{
    	//gameDao.deleteAll();
    }

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void saveTest() {
		TsscTopic topic = new TsscTopic();
		topic.setName("name");
		topic.setDefaultGroups(10);
		topic.setDefaultSprints(20);
		topic.setDescription("description");
		topicDao.save(topic);
		
		assertEquals("name", topicDao.findById(topic.getId()).getName());
		assertTrue(10==topicDao.findById(topic.getId()).getDefaultGroups());
		assertTrue(20==topicDao.findById(topic.getId()).getDefaultSprints());
		assertEquals("description",topicDao.findById(topic.getId()).getDescription());
	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void updateTest() {
		TsscTopic topic = new TsscTopic();
		topic.setName("name");
		topic.setDefaultGroups(10);
		topic.setDefaultSprints(20);
		topic.setDescription("description");
		topicDao.save(topic);
		TsscTopic toModificate = topicDao.findById(topic.getId());
		toModificate.setName("updateName");
		toModificate.setDefaultGroups(20);
		toModificate.setDefaultSprints(30);
		toModificate.setDescription("modificated description");
		
		assertEquals("updateName", topic.getName());
		assertTrue(20==topic.getDefaultGroups());
		assertTrue(30==topic.getDefaultSprints());
		assertEquals("modificated description", topic.getDescription());
		
	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void deleteTest() {
		TsscTopic topic = new TsscTopic();
		topic.setName("topic name");
		topic.setDefaultGroups(10);
		topic.setDefaultSprints(20);
		topic.setDescription("description");
		topicDao.save(topic);
		assertNotNull(topicDao.findById(topic.getId()));
		topicDao.delete(topic);

		assertNull(topicDao.findById(topic.getId()));
		
		
	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void findByNameTest() {
		TsscTopic topic = new TsscTopic();
		topic.setName("name");
		topic.setDefaultGroups(10);
		topic.setDefaultSprints(20);
		topic.setDescription("description");
		topicDao.save(topic);
		assertEquals(topicDao.findByName("name").getDescription(),topic.getDescription());
		assertTrue(topicDao.findByName("name").getDefaultGroups()==topic.getDefaultGroups());
		assertTrue(topicDao.findByName("name").getDefaultSprints()==topic.getDefaultSprints());
		
	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void findByIdTest() {
		TsscTopic topic = new TsscTopic();
		topic.setName("name");
		topic.setDefaultGroups(10);
		topic.setDefaultSprints(20);
		topic.setDescription("description");
		topicDao.save(topic);
		
		
		assertEquals("name", topicDao.findById(topic.getId()).getName());
		assertTrue(10==topicDao.findById(topic.getId()).getDefaultGroups());
		assertTrue(20==topicDao.findById(topic.getId()).getDefaultSprints());
		assertEquals("description", topicDao.findById(topic.getId()).getDescription());
	}
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testFindAll() {
		
		TsscTopic topic1 = new TsscTopic();
		topic1.setName("Topic 1");
		topic1.setDefaultGroups(10);
		topic1.setDefaultSprints(20);
		topic1.setDescription("description");
		topicDao.save(topic1);

		TsscTopic topic2 = new TsscTopic();
		topic2.setName("Topic 2");
		topic2.setDefaultGroups(10);
		topic2.setDefaultSprints(20);
		topic2.setDescription("description");
		topicDao.save(topic2);

		TsscTopic topic3 = new TsscTopic();
		topic3.setName("Topic 3");
		topic3.setDefaultGroups(10);
		topic3.setDefaultSprints(20);
		topic3.setDescription("description");
		topicDao.save(topic3);
		
		/* son 5 los que est�n en la base de datos 
		 si solo se prueban los que se crean en esta clase
		 son 8 si se hacen las pruebas de todas las clases*/
														
		assertEquals(8, topicDao.findAll().size());
		
		
		
	}
	
	

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void finByDescriptionTest() {
		TsscTopic topic = new TsscTopic();
		topic.setName("specific name");
		topic.setDefaultGroups(10);
		topic.setDefaultSprints(20);
		topic.setDescription("ddos description");
		topicDao.save(topic);
		
		assertNotNull(topicDao.findByDescription(topic.getDescription()));
		assertEquals("specific name",topicDao.findByDescription(topic.getDescription()).get(0).getName());
		assertEquals("ddos description",topicDao.findByDescription(topic.getDescription()).get(0).getDescription());
		assertTrue(10==topicDao.findByDescription(topic.getDescription()).get(0).getDefaultGroups());
		assertTrue(20==topicDao.findByDescription(topic.getDescription()).get(0).getDefaultSprints());
	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void findTopicsByGameDateOrderedByTimeTest() {
		
LocalDate localDate1 = LocalDate.of(2020,3,2);
		
		TsscGame game1 = new TsscGame();
		game1.setName("game topics ordered by time 1");
		game1.setScheduledDate(localDate1);
		game1.setStartTime(LocalTime.of(10,43,12));
		
		TsscGame game2 = new TsscGame();
		game2.setName("game topics ordered by time 2");
		game2.setScheduledDate(localDate1);
		game2.setStartTime(LocalTime.of(9,43,12));
		
		List<TsscGame> games = new ArrayList<>();
		games.add(game1);
		games.add(game2);

		TsscTopic topic1 = new TsscTopic();
		topic1.setName("topic ordered by time 1");
		topic1.setDefaultGroups(11);
		topic1.setDefaultSprints(22);
		topic1.setDescription("topic ordered by time 1 description");
		topic1.setTsscGames(games);
		topicDao.save(topic1);
		
		
		TsscTopic topic2 = new TsscTopic();
		topic2.setName("topic ordered by time 2");
		topic2.setDefaultGroups(33);
		topic2.setDefaultSprints(44);
		topic2.setDescription("topic ordered by time 2 description");
		topic1.setTsscGames(games);
		topicDao.save(topic2);
		
		
		game1.setTsscTopic(topic1);
		gameDao.save(game1);
		
		
		game2.setTsscTopic(topic2);
		gameDao.save(game2);
		

		TsscTopic resultTopic1  = topicDao.findTopicsByGameDateOrderedByTime(localDate1).get(1);
		TsscTopic resultTopic2  = topicDao.findTopicsByGameDateOrderedByTime(localDate1).get(0);

		
		if(resultTopic1!=null && resultTopic2!=null) {
			
			//topic 1
			assertEquals("topic ordered by time 1", resultTopic1.getName());
			assertTrue(11==resultTopic1.getDefaultGroups());
			assertTrue(22==resultTopic1.getDefaultSprints());
			assertEquals("topic ordered by time 1 description",resultTopic1.getDescription());
		
			//topic 2
			assertEquals("topic ordered by time 2", resultTopic2.getName());
			assertTrue(33==resultTopic2.getDefaultGroups());
			assertTrue(44==resultTopic2.getDefaultSprints());
			assertEquals("topic ordered by time 2 description",resultTopic2.getDescription());
			
			//verifica la cantidad de topic que encuentra == 2
			assertTrue(2==topicDao.findTopicsByGameDateOrderedByTime(localDate1).size());	
		}
		else {
			fail(" topic 1 null || topic 2 null");
			
		}
		
		

		
		
		
	}

}
