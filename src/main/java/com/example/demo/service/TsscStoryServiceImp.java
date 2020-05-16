package com.example.demo.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.TsscStory;
import com.example.demo.repository.TsscGameRepository;
import com.example.demo.repository.TsscStoryRepository;

import lombok.extern.java.Log;
@Log
@Service
public class TsscStoryServiceImp implements TsscStoryService {
	
	private TsscStoryRepository repository;
	private TsscGameRepository gameRepository;
	

	public TsscStoryServiceImp(TsscStoryRepository repository, TsscGameRepository gameRepository) {
		this.repository= repository;
		this.gameRepository=gameRepository;
	}

	@Override
	public boolean save(TsscStory story) {
		boolean check = (story.getBusinessValue().compareTo(BigDecimal.ZERO)==1 
				&& story.getInitialSprint().compareTo(BigDecimal.ZERO)==1
				&& story.getPriority().compareTo(BigDecimal.ZERO)==1 );
		if(check) {
			if(story.getTsscGame()!=null) {
				if(gameRepository.existsById(story.getTsscGame().getId())) {
					repository.save(story);
				}else {
					check = false;
				}
			}else {
				repository.save(story);
			}
		
		}
		return check;
	}

	@Override
	public boolean existById(long id) {
		return repository.existsById(id);
	}

	@Override
	public TsscStory findById(long id) {
		return repository.findById(id).get();
	}
	
	public Iterable<TsscStory> findAll(){
		return repository.findAll();
	}
	
	public void deleteTsscStory(TsscStory tsscStory) {
		repository.delete(tsscStory);
	}

}
