package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TsscGame;
import com.example.demo.model.TsscStory;
import com.example.demo.model.TsscTimecontrol;
import com.example.demo.model.TsscTopic;
import com.example.demo.repository.TsscGameRepository;
import com.example.demo.repository.TsscTopicRepository;

import lombok.extern.java.Log;

@Log
@Service
public class TsscGameServiceImp implements TsscGameService {
	


	private TsscGameRepository repository;
	private TsscTopicRepository topicRepository;
	
	@Autowired
	TsscGameServiceImp(TsscGameRepository repository, TsscTopicRepository topicRepository){
	this.repository = repository;
	this.topicRepository = topicRepository;
	}



	@Override
	public boolean existById(long id) {
		return repository.existsById(id);
	}

	@Override
	public TsscGame findById(long id) {
		return repository.findById(id).get();
	}

	@Override
	public boolean save(TsscGame game) {
		boolean check = (game.getNGroups()>0 && game.getNSprints()>0);
		if(check) {
			if(game.getTsscTopic()==null) {
				repository.save(game);
			}else {
				if(topicRepository.existsById(game.getTsscTopic().getId())) {
					repository.save(game);
				}else {
					check = false;
				}
			}
		}
		return check;
	}
	
	@Override
	public boolean save2(TsscGame game, long id) {
		boolean check = game.getNGroups()>0 && game.getNSprints()>0;
		if(game.getNGroups()>0 && game.getNSprints()>0) {
			if(game.getTsscTopic() == null) {
				repository.save(game);
			}
			else {
				if(topicRepository.existsById(id)) {
					List<TsscTimecontrol> listTimecontrol = game.getTsscTopic().getTsscTimecontrols();
					game.getTsscTimecontrols().addAll(listTimecontrol);
					List<TsscStory> lisStories = game.getTsscTopic().getTsscStories();
					game.getTsscStories().addAll(lisStories);
					repository.save(game);
				}
				else {
					check = false;
				}
			}
		}
		return check;
	}
	
	
	public Iterable<TsscGame> findAll(){
		return repository.findAll();
	}
	
	
	public TsscTopicRepository getTopicRepository() {
		return topicRepository;
	}



	public void setTopicRepository(TsscTopicRepository topicRepository) {
		this.topicRepository = topicRepository;
	}
	
	public void deleteTsscGame(TsscGame tsscGame) {
		repository.delete(tsscGame);
	}
	
	







	
	
	
	

}
