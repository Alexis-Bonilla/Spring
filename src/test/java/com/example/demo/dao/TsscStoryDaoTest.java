package com.example.demo.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

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
import com.example.demo.model.TsscStory;


@SpringBootTest(classes = TallerPruebasApplication.class)
@Rollback(false)
@ExtendWith(SpringExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class TsscStoryDaoTest {
	
	@Autowired
	TsscStoryDao storyDao ;

	@BeforeEach
	void setUp() throws Exception {
		storyDao.deleteAll();
	}
	
    @AfterEach
    void afterEach() throws Exception{
    	storyDao.deleteAll();
    }

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void saveTest() {
		
		TsscStory story = new TsscStory();
		story.setDescription("description");
		story.setBusinessValue(new BigDecimal(10));
		story.setPriority(new BigDecimal(20));
		story.setInitialSprint(new BigDecimal(30));
		storyDao.save(story);
		
		storyDao.findById(story.getId());
		assertNotNull(storyDao.findById(story.getId()));
		
	}
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testFindAll() {
		
		
		TsscStory story1 = new TsscStory();
		story1.setDescription("description story 1");
		story1.setBusinessValue(new BigDecimal(1));
		story1.setPriority(new BigDecimal(2));
		story1.setInitialSprint(new BigDecimal(3));
		storyDao.save(story1);
		
		TsscStory story2 = new TsscStory();
		story2.setDescription("description story 2");
		story2.setBusinessValue(new BigDecimal(4));
		story2.setPriority(new BigDecimal(5));
		story2.setInitialSprint(new BigDecimal(6));
		storyDao.save(story2);
		
		TsscStory story3 = new TsscStory();
		story3.setDescription("description story 3");
		story3.setBusinessValue(new BigDecimal(7));
		story3.setPriority(new BigDecimal(8));
		story3.setInitialSprint(new BigDecimal(9));
		storyDao.save(story3);

		assertEquals(3, storyDao.findAll().size());

		
	}
	

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)

	void updateTest() {
		
		
		TsscStory story = new TsscStory();
		story.setDescription("description");
		story.setBusinessValue(new BigDecimal(10));
		story.setPriority(new BigDecimal(20));
		story.setInitialSprint(new BigDecimal(30));
		storyDao.save(story);
	
		storyDao.findById(story.getId()).setDescription("updated description");
		assertEquals("updated description", storyDao.findById(story.getId()).getDescription());

	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)

	void testDelete() {
		
		TsscStory story = new TsscStory();
		story.setDescription("description");
		story.setBusinessValue(new BigDecimal(10));
		story.setPriority(new BigDecimal(20));
		story.setInitialSprint(new BigDecimal(30));
		storyDao.save(story);
		storyDao.delete(storyDao.findById(story.getId()));
		assertNull(storyDao.findById(story.getId()));
	}

}
