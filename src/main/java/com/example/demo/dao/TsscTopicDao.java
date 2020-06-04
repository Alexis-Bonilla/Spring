package com.example.demo.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.util.Pair;

import com.example.demo.model.TsscTopic;




public interface TsscTopicDao {
	
	

	public void save(TsscTopic entity);
	public void update(TsscTopic entity);
	public void delete(TsscTopic  entity);
	public TsscTopic findById(Long id);
	public List<TsscTopic> findAll();
	public boolean existById(long id);
	public TsscTopic findByName(String name);
	public List<TsscTopic> findByDescription(String description);
	public List<TsscTopic> findTopicsByGameDateOrderedByTime(LocalDate date);
	public void deleteAll();
	
	
	

}
