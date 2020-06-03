package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.TsscGameDao;
import com.example.demo.dao.TsscStoryDao;
import com.example.demo.dao.TsscTimeControlDao;
import com.example.demo.dao.TsscTopicDao;
import com.example.demo.model.TsscGame;
import com.example.demo.model.TsscStory;
import com.example.demo.model.TsscTimecontrol;
import com.example.demo.model.TsscTopic;
import com.example.demo.repository.TsscTopicRepository;

@Service
@Scope("singleton")
public class TsscTopicServiceImp implements TsscTopicService{
	
	
	private TsscTopicDao topicDao;
	private TsscStoryDao storyDao;
	private TsscTimeControlDao timeControlDao;

	
	@Autowired
	public TsscTopicServiceImp(TsscTopicDao dao, TsscStoryDao storyDao, TsscTimeControlDao timeControlDao) {
		this.topicDao=dao;
		this.storyDao = storyDao;
		this.timeControlDao = timeControlDao;
	}
	
	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean save(TsscTopic topic) {
		boolean check= (topic.getDefaultGroups()>0&&topic.getDefaultSprints()>0);
		if(check && topic != null) {
			topicDao.save(topic);
		}
		return check;
	}
	
	
	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(TsscTopic topic) {
		boolean check= (topic.getDefaultGroups()>0&&topic.getDefaultSprints()>0);
		if(check && topic != null) {
			topicDao.update(topic);
		}
		return check;
	}
	
	
	
	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
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
		Iterable<TsscGame> games = tsscTopic.getTsscGames();
		
		for (TsscGame game : games) {
			game.setTsscTopic(null);
		}

		Iterable<TsscStory> stories = tsscTopic.getTsscStories();
	
		for (TsscStory story : stories) {
			story.setTsscTopic(null);
		}
		
		Iterable<TsscTimecontrol> times = tsscTopic.getTsscTimecontrols();
		for (TsscTimecontrol tsscTimecontrol : times) {
			tsscTimecontrol.setTsscTopic(null);
		}
		
		
		
		topicDao.delete(tsscTopic);
	}


	
	
	
	
	
	
	
	
	
	
}
