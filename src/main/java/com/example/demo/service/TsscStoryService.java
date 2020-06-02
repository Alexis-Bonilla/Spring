package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.TsscStory;


public interface TsscStoryService {
	
	public boolean save(TsscStory story);
	public boolean existById (long id);
	public TsscStory findById(long id);
	public Iterable<TsscStory> findAll();
	public void deleteTsscStory(TsscStory tsscStory);
	public boolean update(TsscStory story);
	
}
