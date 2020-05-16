package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TsscTopic;
import com.example.demo.repository.TsscTopicRepository;
@Service
public class TsscTopicServiceImp implements TsscTopicService{
	
	private TsscTopicRepository repository;
	
	@Autowired
	public TsscTopicServiceImp(TsscTopicRepository repository) {
		this.repository=repository;
	}
	
	@Override
	public boolean save(TsscTopic topic) {
		boolean check= (topic.getDefaultGroups()>0&&topic.getDefaultSprints()>0);
		if(check) {
			repository.save(topic);
		}
		return check;
	}
	
	@Override
	public TsscTopic findById(long id) {
		return repository.findById(id).get();
	}
	
	@Override
	public boolean existById(long id) {
		return repository.existsById(id);
	}

	@Override
	public boolean updateDefaultGroups(long id, long groups) {
		boolean check= repository.existsById(id);
		if(check) {
			repository.findById(id).get().setDefaultGroups(groups);
		}
		return check;
	}

	@Override
	public boolean updateDefaultSprints(long id, long sprints) {
		boolean check= repository.existsById(id);
		if(check) {
			repository.findById(id).get().setDefaultSprints(sprints);
		}
		return check;
	}

	public void clearTopics() {
		repository.deleteAll();
	}

	public Object findAll() {
		return repository.findAll();
	}

	public void deleteTsscTopic(TsscTopic tsscTopic) {
		repository.delete(tsscTopic);
	}
	
	
	
	
	
	
	
	
	
	
}
