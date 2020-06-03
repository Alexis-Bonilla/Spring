package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.TsscGameDao;
import com.example.demo.dao.TsscTimeControlDao;
import com.example.demo.model.TsscTimecontrol;


@Service
@Scope("singleton")
public class TsscTimeControlServiceImp implements TsscTimeControlService{

	private TsscTimeControlDao timecontrolDao;
	private TsscGameDao gameDao;

	@Autowired
	public TsscTimeControlServiceImp(TsscTimeControlDao timecontrolDao) {
		super();
		this.timecontrolDao = timecontrolDao;
	}
	

	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void save(TsscTimecontrol t) {
		if(t!=null)
			timecontrolDao.save(t);
		
		
	}


	@Override
	@Transactional(readOnly=true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public TsscTimecontrol findById(long id) {
		return timecontrolDao.findById(id);
	}


	@Override
	@Transactional(readOnly=true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Iterable<TsscTimecontrol> findAll() {
		return timecontrolDao.findAll();
		
	}


	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void update(TsscTimecontrol t) {
		if(t!=null)
			timecontrolDao.update(t);
	}


	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(TsscTimecontrol timecontrol) {

		
		
		timecontrolDao.delete(timecontrol);
		
	}
	
	
}
