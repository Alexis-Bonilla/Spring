package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.TsscTimecontrol;


public interface TsscTimeControlDao {
	
	public void save(TsscTimecontrol entity);
	public void update(TsscTimecontrol entity);
	public void delete(TsscTimecontrol entity);
	public TsscTimecontrol findById(long id);
	public List<TsscTimecontrol> findAll();

}
