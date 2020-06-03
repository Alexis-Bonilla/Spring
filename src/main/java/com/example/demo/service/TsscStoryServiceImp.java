package com.example.demo.service;

import java.math.BigDecimal;
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
import com.example.demo.model.TsscAcceptanceCriteria;
import com.example.demo.model.TsscDeliverable;
import com.example.demo.model.TsscStory;

import lombok.extern.java.Log;


@Log
@Service
@Scope("singleton")
public class TsscStoryServiceImp implements TsscStoryService {
	

	private TsscStoryDao storyDao;
	private TsscGameDao gameDao;
	private TsscTopicDao topicDao;
	
	@Autowired
	public TsscStoryServiceImp(TsscStoryDao repository, TsscGameDao gameDao, TsscTopicDao topicDao) {
		this.storyDao= repository;
		this.gameDao=gameDao;
		this.topicDao=topicDao;

		
	}

	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean save(TsscStory story) {
		boolean check = false;
		if(story!=null) {
			
			log.info("STORY DIFERENTE DE NULL");
			check = (story.getBusinessValue().compareTo(BigDecimal.ZERO)==1 
					&& story.getInitialSprint().compareTo(BigDecimal.ZERO)==1
					&& story.getPriority().compareTo(BigDecimal.ZERO)==1 )
					&& story != null
					;
			if(check) {
				log.info("los valores son mayor a cero");
				
				if(story.getTsscGame()!=null) {
					
					log.info("EL JUEGO DE LA HISTORIA ES DISTINTO DE NULL");
					if(gameDao.existById(story.getTsscGame().getId())) {
						
						log.info("VERIFICA QUE EL JUEGO EXISTA CON UN METODO DEL DAO");
						story.setTsscTopic(gameDao.findById(story.getTsscGame().getId()).getTsscTopic());
						
					
						log.info("NOMBRE DEL JUEGO DE LA HISTORIA : "+story.getTsscGame().getName());
						
						List<TsscStory> stories = story.getTsscGame().getTsscStories();
						stories.add(story);
						
						gameDao.update(story.getTsscGame());
						
						
						storyDao.save(story);
						
					}else {
						log.info("NO EXISTE EL JUEGO ASOCIADO A LA HISTORIA");
						check = false;
					}
				}else {
					storyDao.save(story);
				}
			
			}

		}
		
		return check;
	}
	
	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(TsscStory story) {
		boolean check = (story.getBusinessValue().compareTo(BigDecimal.ZERO)==1 
				&& story.getInitialSprint().compareTo(BigDecimal.ZERO)==1
				&& story.getPriority().compareTo(BigDecimal.ZERO)==1 )
				&& story != null
				;
		if(check) {
			if(story.getTsscGame()!=null) {
				if(gameDao.existById(story.getTsscGame().getId())) {
					story.setTsscTopic(gameDao.findById(story.getTsscGame().getId()).getTsscTopic());
					storyDao.update(story);
				}else {
					check = false;
				}
			}else {
				storyDao.update(story);
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
		
		Iterable<TsscAcceptanceCriteria> criterias =tsscStory.getTsscAcceptanceCriterias();
		for (TsscAcceptanceCriteria a : criterias) {
			a.setTsscStory(null);
		}
		Iterable<TsscDeliverable> deliverables = tsscStory.getTsscDeliverables();
		for (TsscDeliverable deliverable : deliverables) {
			deliverable.setTsscStory(null);
		}
		
		
		tsscStory.setTsscState(null);
		
		
		storyDao.delete(tsscStory);
	}



}
