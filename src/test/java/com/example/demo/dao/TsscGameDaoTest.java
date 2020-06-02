package com.example.demo.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
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

import com.example.demo.model.TsscStory;
import com.example.demo.TallerPruebasApplication;
import com.example.demo.model.TsscGame;
import com.example.demo.model.TsscTopic;


@SpringBootTest(classes = TallerPruebasApplication.class)
@Rollback(false)
@ExtendWith(SpringExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class TsscGameDaoTest {
	
	@Autowired
	TsscGameDao gameDao;
	
	@Autowired
	TsscTopicDao topicDao;

	@BeforeEach
	void setUp() throws Exception {
	
	}
	
    @AfterEach
    void afterEach() throws Exception{
    
    }

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void saveTest() {
		
		TsscGame game = new TsscGame();
		game.setName("game");
		game.setNGroups(1);
		game.setNSprints(2);
		game.setAdminPassword("password");
		gameDao.save(game);
		
		assertEquals("game", gameDao.findById(game.getId()).getName());
		assertEquals("password", gameDao.findById(game.getId()).getAdminPassword());
		assertTrue(1==gameDao.findById(game.getId()).getNGroups());
		assertTrue(2==gameDao.findById(game.getId()).getNSprints());
		
		
	
	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void updateTest() {
		
		TsscGame game = new TsscGame();
		game.setName("game");
		game.setNGroups(1);
		game.setNSprints(2);
		game.setAdminPassword("password");
		gameDao.save(game);
		
		TsscGame toUpdate = gameDao.findById(game.getId());
		toUpdate.setName("update name");
		toUpdate.setNGroups(2);
		toUpdate.setNSprints(3);
		toUpdate.setAdminPassword("updatePassword");
		gameDao.update(toUpdate);
		assertEquals("update name",gameDao.findById(game.getId()).getName());
		assertEquals("updatePassword",gameDao.findById(game.getId()).getAdminPassword());
		assertTrue(2==gameDao.findById(game.getId()).getNGroups());
		assertTrue(3==gameDao.findById(game.getId()).getNSprints());
	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void deleteTest() {

		TsscGame game = new TsscGame();
		game.setName("game");
		game.setNGroups(1);
		game.setNSprints(2);
		game.setAdminPassword("password");
		gameDao.save(game);
		gameDao.delete(game);
		assertNull(gameDao.findById(game.getId()));
	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void finByIdTest() {
		
		TsscGame game = new TsscGame();
		game.setName("game");
		game.setNGroups(1);
		game.setNSprints(2);
		game.setAdminPassword("password");
		gameDao.save(game);
	
		assertNotNull(gameDao.findById(game.getId()));
		
		
	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void findByIdTopicTest() {
		
		TsscTopic topic = new TsscTopic();
		topic.setName("topic name");
		topic.setDefaultGroups(10);
		topic.setDefaultSprints(20);
		topic.setDescription("description");
		topicDao.save(topic);
		
		TsscGame game = new TsscGame();
		game.setName("game name");
		game.setNGroups(1);
		game.setNSprints(2);
		game.setAdminPassword("123");
		game.setTsscTopic(topic);
		gameDao.save(game);
		
		assertEquals("game name",gameDao.findByIdTopic(topic.getId()).get(0).getName() );
	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void findByNameTest() {
		
		TsscGame game = new TsscGame();
		game.setName("game");
		game.setNGroups(1);
		game.setNSprints(2);
		game.setAdminPassword("password");
		gameDao.save(game);

		assertNotNull(gameDao.findByName("game"));
		assertTrue(game.getId()==gameDao.findByName("game").getId());
	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void findByTopicDescriptionTest() {
		
		TsscTopic topic = new TsscTopic();
		topic.setName("topic name");
		topic.setDefaultGroups(10);
		topic.setDefaultSprints(20);
		topic.setDescription("description specific");
		topicDao.save(topic);
		
		
		
		TsscGame game = new TsscGame();
		game.setName("game name");
		game.setNGroups(1);
		game.setNSprints(2);
		game.setAdminPassword("123");
		game.setTsscTopic(topic);
		gameDao.save(game);

		assertEquals("game name",gameDao.findByTopicDescription("description specific").get(0).getName() );
		
		
	}
	
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void findByDateStoryTimeTest() {
		
		
		TsscTopic topic = new TsscTopic();
		topic.setName("topic name");
		topic.setDefaultGroups(10);
		topic.setDefaultSprints(20);
		topic.setDescription("description");
		topicDao.save(topic);
		
		TsscStory story1 = new TsscStory();
		story1.setBusinessValue(new BigDecimal(1));
		story1.setPriority(new BigDecimal(2));
		story1.setDescription("story 1 description");
		story1.setTsscTopic(topic);
		
		TsscStory story2 = new TsscStory();
		story2.setBusinessValue(new BigDecimal(3));
		story2.setPriority(new BigDecimal(4));
		story2.setDescription("story 2 description");
		story2.setTsscTopic(topic);
		
		
		TsscStory story3 = new TsscStory();
		story3.setBusinessValue(new BigDecimal(5));
		story3.setPriority(new BigDecimal(6));
		story3.setDescription("story 3 description");
		story3.setTsscTopic(topic);
		
		TsscStory story4 = new TsscStory();
		story4.setBusinessValue(new BigDecimal(7));
		story4.setPriority(new BigDecimal(8));
		story4.setDescription("story 4 description");
		story4.setTsscTopic(topic);
		
		TsscStory story5 = new TsscStory();
		story5.setBusinessValue(new BigDecimal(9));
		story5.setPriority(new BigDecimal(10));
		story5.setDescription("story 5 description");
		story5.setTsscTopic(topic);
		
		
		TsscStory story6 = new TsscStory();
		story6.setBusinessValue(new BigDecimal(11));
		story6.setPriority(new BigDecimal(12));
		story6.setDescription("story 6 description");
		story6.setTsscTopic(topic);
		
		TsscStory story7 = new TsscStory();
		story7.setBusinessValue(new BigDecimal(13));
		story7.setPriority(new BigDecimal(14));
		story7.setDescription("story 7 description");
		story7.setTsscTopic(topic);
		
		
		TsscStory story8 = new TsscStory();
		story8.setBusinessValue(new BigDecimal(15));
		story8.setPriority(new BigDecimal(16));
		story8.setDescription("story 8 description");
		story8.setTsscTopic(topic);
		
		
		TsscStory story9 = new TsscStory();
		story9.setBusinessValue(new BigDecimal(17));
		story9.setPriority(new BigDecimal(18));
		story9.setDescription("story 8 description");
		story9.setTsscTopic(topic);
		
		TsscStory story10 = new TsscStory();
		story10.setBusinessValue(new BigDecimal(19));
		story10.setPriority(new BigDecimal(20));
		story10.setDescription("story 10 description");
		story10.setTsscTopic(topic);
		
		
		LocalDate date = LocalDate.of(2020,2,1);
		TsscGame game = new TsscGame();
		
		game.setName("game name");
		game.setNGroups(1);
		game.setNSprints(2);
		game.setAdminPassword("123");
		
		game.setScheduledDate(date);
		
		List <TsscStory> stories = new ArrayList<>();
		stories.add(story1);
		stories.add(story2);
		stories.add(story3);
		stories.add(story4);
		stories.add(story5);
		stories.add(story6);
		stories.add(story7);
		stories.add(story8);
		stories.add(story9);
		stories.add(story10);
		
		game.setTsscStories(stories);
		
		gameDao.save(game);

		gameDao.findByDateStoryTime(date);
		
		assertEquals("game name", gameDao.findById(game.getId()).getName());
		assertTrue(1==gameDao.findById(game.getId()).getNGroups());
		assertTrue(2==gameDao.findById(game.getId()).getNSprints());
		assertEquals("123", gameDao.findById(game.getId()).getAdminPassword());
	}
	

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void findByDateRangeTest() {
		
		LocalDate date = LocalDate.of(2020,2,1);
		TsscGame game = new TsscGame();
		game.setName("game");
		game.setNGroups(1);
		game.setNSprints(2);
		game.setAdminPassword("password");
		game.setScheduledDate(date);
		gameDao.save(game);
		
		LocalDate localDate1 = LocalDate.of(2020,1,1);
		LocalDate localDate2 = LocalDate.of(2020,2,2);
		assertEquals(1,gameDao.findByDateRange(localDate1, localDate2).size());

		
		
	}


}
