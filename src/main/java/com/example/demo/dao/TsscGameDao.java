package com.example.demo.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.example.demo.model.TsscGame;
import com.example.demo.model.TsscTopic;





public interface TsscGameDao {
	
	

	public void save(TsscGame entity);
	public void update(TsscGame entity);
	public void delete(TsscGame  entity);
	public TsscGame findById(Long id);
	public List<TsscGame> findAll();
	public List<TsscGame> findByIdTopic(Long iD);
	public TsscGame findByName(String name);
	public List<TsscGame> findByDescription(String description);
	public List<TsscGame> findByDateRange(LocalDate date1, LocalDate date2);
	public List<TsscGame> findByDateTimeRange(LocalDate date1, LocalTime time1, LocalTime time2);
	public List<TsscGame> findByDateStoryTime(LocalDate date1);
	public List<TsscGame> findByTopicDescription(String string);
	public void deleteAll();
	public boolean existById(long id);

	
	
}
