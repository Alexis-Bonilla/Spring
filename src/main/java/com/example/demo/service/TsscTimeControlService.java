package com.example.demo.service;

import com.example.demo.model.TsscTimecontrol;

public interface TsscTimeControlService {
	
	public void save(TsscTimecontrol t);
	public void update(TsscTimecontrol t);
	public TsscTimecontrol findById(long id);
	public Iterable<TsscTimecontrol> findAll();
	public void delete(TsscTimecontrol timecontrol);

}
