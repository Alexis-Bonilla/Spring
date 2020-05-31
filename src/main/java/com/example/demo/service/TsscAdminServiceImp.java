package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.TsscAdminDao;
import com.example.demo.model.TsscAdmin;
import com.example.demo.repository.TsscAdminRepository;



@Service
@Scope("singleton")
public class TsscAdminServiceImp implements TsscAdminService{
	
	@Autowired
	TsscAdminDao adminDao;


	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void save(TsscAdmin nuevo) {
		adminDao.save(nuevo);
	}

	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void edit(TsscAdmin editado) {
		adminDao.save(editado);
	}

	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(TsscAdmin delete) {
		adminDao.delete(delete);
	}

	@Override
	public Iterable<TsscAdmin> findAll() {
		return adminDao.findAll();
	}
	
	

}
