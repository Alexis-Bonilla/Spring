package com.example.demo.dao;

import static org.junit.jupiter.api.Assertions.*;

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
import com.example.demo.model.TsscAdmin;



@SpringBootTest(classes = TallerPruebasApplication.class)
@Rollback(false)
@ExtendWith(SpringExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class TsscAdminDaoTest {
	
	@Autowired
	TsscAdminDao adminDao;

	@BeforeEach
	void setUp() throws Exception {
		adminDao.deleteAll();
	}
	
    @AfterEach
    void afterEach() throws Exception{
    	adminDao.deleteAll();
    }

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void saveTest() {
		
		
		TsscAdmin admin = new TsscAdmin();
		admin.setUser("Alexis");
		admin.setPassword("123");
		admin.setSuperAdmin("superAdministrator");
		adminDao.save(admin);
		assertEquals("Alexis", adminDao.findById(admin.getId()).getUser());
		
		
		
	
	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void updateTest() {
		TsscAdmin admin = new TsscAdmin();
		admin.setUser("Alexis");
		admin.setPassword("123");
		admin.setSuperAdmin("superAdministrator");
		adminDao.save(admin);
		adminDao.findById(admin.getId()).setUser("Bonilla");
		adminDao.update(admin);
		assertEquals("Bonilla", adminDao.findById(admin.getId()).getUser());
	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void deleteTest() {

		TsscAdmin admin = new TsscAdmin();
		admin.setUser("Alexis");
		admin.setPassword("123");
		admin.setSuperAdmin("superAdministrator");
		adminDao.save(admin);
		adminDao.delete(adminDao.findById(admin.getId()));
		assertNull(adminDao.findById(admin.getId()));
	}

	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void findByIdTest() {
		
		TsscAdmin admin = new TsscAdmin();
		admin.setUser("Alexis");
		admin.setPassword("123");
		admin.setSuperAdmin("superAdministrator");
		adminDao.save(admin);
		assertNotNull(adminDao.findById(admin.getId()).getUser());
	}
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	void testFindAll() {
	
		TsscAdmin admin = new TsscAdmin();
		admin.setUser("Alexis");
		admin.setPassword("123");
		admin.setSuperAdmin("superAdministrator");
		adminDao.save(admin);
		
		
		
		assertEquals(1,adminDao.findAll().size());
		
	}

}
