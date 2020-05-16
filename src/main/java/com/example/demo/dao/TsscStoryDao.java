package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.TsscStory;

public interface TsscStoryDao {
	
	public void save(TsscStory entity);
	public void update(TsscStory entity);
	public void delete(TsscStory  entity);
	public TsscStory findById(Long id);
	public List<TsscStory> findAll();
	public void deleteAll();

}
