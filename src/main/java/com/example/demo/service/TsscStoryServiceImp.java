package com.example.demo.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.TsscGameDao;
import com.example.demo.dao.TsscStoryDao;
import com.example.demo.model.TsscStory;


import lombok.extern.java.Log;


@Log
@Service
@Scope("singleton")
public class TsscStoryServiceImp implements TsscStoryService {
	

	private TsscStoryDao storyDao;
	private TsscGameDao gameDao;
	
	@Autowired
	public TsscStoryServiceImp(TsscStoryDao repository, TsscGameDao gameDao) {
		this.storyDao= repository;
		this.gameDao=gameDao;

		
	}

	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean save(TsscStory story) {
		boolean check = (story.getBusinessValue().compareTo(BigDecimal.ZERO)==1 
				&& story.getInitialSprint().compareTo(BigDecimal.ZERO)==1
				&& story.getPriority().compareTo(BigDecimal.ZERO)==1 )
				&& story != null
				;
		if(check) {
			if(story.getTsscGame()!=null) {
				if(gameDao.existById(story.getTsscGame().getId())) {
					
					story.setTsscTopic(gameDao.findById(story.getTsscGame().getId()).getTsscTopic());
					storyDao.save(story);
				}else {
					check = false;
				}
			}else {
				storyDao.save(story);
			}
		
		}
		return check;
	}

	@Override
	@Transactional(readOnly=true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean existById(long id) {
		return storyDao.existById(id);
	}

	@Override
	@Transactional(readOnly=true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public TsscStory findById(long id) {
		return storyDao.findById(id);
	}
	
	@Override
	@Transactional(readOnly=true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Iterable<TsscStory> findAll(){
		return storyDao.findAll();
	}
	
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteTsscStory(TsscStory tsscStory) {
		storyDao.delete(tsscStory);
	}

}
