package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.example.demo.dao.TsscAdminDao;
import com.example.demo.model.TsscAdmin;
import com.example.demo.repository.TsscAdminRepository;



@Service
@Scope("singleton")
public class TsscAdminServiceImp implements TsscAdminService{
	
	@Autowired
	TsscAdminDao adminDao;


	@Override
	public void save(TsscAdmin nuevo) {
		adminDao.save(nuevo);
	}

	@Override
	public void edit(TsscAdmin editado) {
		adminDao.save(editado);
	}

	@Override
	public void delete(TsscAdmin delete) {
		adminDao.delete(delete);
	}
	
	

}
