package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.TsscTopicDao;
import com.example.demo.model.TsscTopic;
import com.example.demo.repository.TsscTopicRepository;

@Service
@Scope("singleton")
public class TsscTopicServiceImp implements TsscTopicService{
	
	
	private TsscTopicDao topicDao;
	
	@Autowired
	public TsscTopicServiceImp(TsscTopicDao dao) {
		this.topicDao=dao;
	}
	
	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean save(TsscTopic topic) {
		boolean check= (topic.getDefaultGroups()>0&&topic.getDefaultSprints()>0);
		if(check) {
			topicDao.save(topic);
		}
		return check;
	}
	
	@Override
	@Transactional(readOnly=true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public TsscTopic findById(long id) {
		return topicDao.findById(id);
	}
	
	@Override
	@Transactional(readOnly=true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean existById(long id) {
		return topicDao.existById(id);
	}

	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean updateDefaultGroups(long id, long groups) {
		boolean check= topicDao.existById(id);
		if(check) {
			topicDao.findById(id).setDefaultGroups(groups);
		}
		return check;
	}

	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean updateDefaultSprints(long id, long sprints) {
		boolean check= topicDao.existById(id);
		if(check) {
			topicDao.findById(id).setDefaultSprints(sprints);
		}
		return check;
	}

	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void clearTopics() {
		topicDao.deleteAll();
	}

	@Override
	@Transactional(readOnly=true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Iterable<TsscTopic> findAll() {
		return topicDao.findAll();
	}

	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteTsscTopic(TsscTopic tsscTopic) {
		topicDao.delete(tsscTopic);
	}
	
	
	
	
	
	
	
	
	
	
}
