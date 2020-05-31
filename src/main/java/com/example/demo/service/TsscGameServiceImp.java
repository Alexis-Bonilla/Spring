package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.TsscGameDao;
import com.example.demo.dao.TsscStoryDao;
import com.example.demo.dao.TsscTopicDao;
import com.example.demo.model.TsscGame;
import com.example.demo.model.TsscStory;
import com.example.demo.model.TsscTimecontrol;
import com.example.demo.model.TsscTopic;
import com.example.demo.repository.TsscGameRepository;
import com.example.demo.repository.TsscTopicRepository;

import lombok.extern.java.Log;

@Log
@Service
@Scope("singleton")
public class TsscGameServiceImp implements TsscGameService {
	


	private TsscGameDao gameDao;
	private TsscTopicDao topicDao;
	private TsscStoryDao storyDao;
	
	@Autowired
	TsscGameServiceImp(TsscGameDao repository, TsscTopicDao topicRepository, TsscStoryDao storyDao){
	this.gameDao = repository;
	this.topicDao = topicRepository;
	this.storyDao = storyDao;
	}



	@Override
	@Transactional(readOnly=true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean existById(long id) {
		return gameDao.existById(id);
	}

	@Override
	@Transactional(readOnly=true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public TsscGame findById(long id) {
		return gameDao.findById(id);
	}

	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean save(TsscGame game) {
		boolean check = (game.getNGroups()>0 && game.getNSprints()>0);
		if(check) {
			if(game.getTsscTopic()==null) {
				gameDao.save(game);
			}else {
				TsscTopic x =  topicDao.findById(game.getTsscTopic().getId());
				if(x!=null) {
					gameDao.save(game);
					ArrayList<TsscStory> stories = new ArrayList<TsscStory>();
					ArrayList<TsscTimecontrol> tcs = new ArrayList<TsscTimecontrol>();
					if(x.getTsscStories() != null) {
						
						for (TsscStory t : x.getTsscStories()) {
							TsscStory n= new TsscStory();
							n.setAltDescripton(t.getAltDescripton());
							n.setBusinessValue(t.getBusinessValue());
							n.setDescription(t.getDescription());
							n.setInitialSprint(t.getInitialSprint());
							n.setPriority(t.getPriority());
							n.setShortDescription(t.getShortDescription());
							n.setNumber(t.getNumber());
							n.setTsscTopic(t.getTsscTopic());
							n.setTsscGame(game);
							stories.add(n);
							storyDao.save(n);
						}
						
					}
					/*
					if(x.getTsscTimecontrols() != null) {

						for (TsscTimecontrol t : x.getTsscTimecontrols()) {
							TsscTimecontrol n = new TsscTimecontrol();
							n.setName(t.getName());
							n.setTimeInterval(t.getTimeInterval());
							n.setName(t.getName());
							n.setAutostart(t.getAutostart());
							n.setIntervalRunning(t.getIntervalRunning());
							n.setTsscGame(game);
							tcs.add(n);
							timecontrolDao.save(n);
						}
						
					}
					*/
				}
				if(topicDao.existById(game.getTsscTopic().getId())) {
					gameDao.save(game);
				}else {
					check = false;
				}
			}
		}
		return check;
	}
	
	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean save2(TsscGame game, long id) {
		boolean check = game.getNGroups()>0 && game.getNSprints()>0;
		if(game.getNGroups()>0 && game.getNSprints()>0) {
			if(game.getTsscTopic() == null) {
				gameDao.save(game);
			}
			else {
				if(topicDao.existById(id)) {
					List<TsscTimecontrol> listTimecontrol = game.getTsscTopic().getTsscTimecontrols();
					game.getTsscTimecontrols().addAll(listTimecontrol);
					List<TsscStory> lisStories = game.getTsscTopic().getTsscStories();
					game.getTsscStories().addAll(lisStories);
					gameDao.save(game);
				}
				else {
					check = false;
				}
			}
		}
		return check;
	}
	
	@Transactional(readOnly=true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Iterable<TsscGame> findAll(){
		return gameDao.findAll();
	}

	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteTsscGame(TsscGame tsscGame) {
		gameDao.delete(tsscGame);
	}
	
	







	
	
	
	

}
