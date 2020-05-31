package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.TsscStory;
import com.example.demo.model.TsscTopic;

public interface TsscStoryDao {
	
	public void save(TsscStory entity);
	public void update(TsscStory entity);
	public void delete(TsscStory  entity);
	public TsscStory findById(Long id);
	public List<TsscStory> findAll();
	public void deleteAll();
	public boolean existById(long id);

}
