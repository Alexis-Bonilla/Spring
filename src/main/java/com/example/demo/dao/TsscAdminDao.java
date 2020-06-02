package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.TsscAdmin;

public interface TsscAdminDao {
	
	public void save(TsscAdmin entity);
	public void update(TsscAdmin entity);
	public void delete(TsscAdmin  entity);
	public TsscAdmin findById(Long id);
	public List<TsscAdmin> findAll();
	public void deleteAll();
	public TsscAdmin findByUser(String username);
}
