package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.TsscTopic;

public interface TsscTopicService {

	public boolean save(TsscTopic topic);
	public TsscTopic findById(long id);
	public boolean existById(long id);
	public boolean updateDefaultGroups(long id,long groups);
	public boolean updateDefaultSprints(long id,long sprints);
	public void clearTopics();
	public Iterable<TsscTopic> findAll();
	public void deleteTsscTopic(TsscTopic tsscTopic);
	public boolean update(TsscTopic topic);
	
	
}