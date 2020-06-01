package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.TsscTimeControlDao;
import com.example.demo.model.TsscTimecontrol;


@Service
@Scope("singleton")
public class TsscTimeControlServiceImp implements TsscTimeControlService{

	TsscTimeControlDao timecontrolDao;

	@Autowired
	public TsscTimeControlServiceImp(TsscTimeControlDao timecontrolDao) {
		super();
		this.timecontrolDao = timecontrolDao;
	}
	

	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void save(TsscTimecontrol t) {
		timecontrolDao.save(t);
		
	}
}
