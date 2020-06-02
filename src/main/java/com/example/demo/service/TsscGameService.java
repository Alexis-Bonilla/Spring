package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.TsscGame;
import com.example.demo.model.TsscTopic;

public interface TsscGameService {

	public boolean save(TsscGame game);
	public boolean existById (long id);
	public TsscGame findById(long id);
	boolean save2(TsscGame game, long id);
	public Iterable<TsscGame> findAll();
	public void delete(TsscGame game);
	public boolean update (TsscGame game);
	
}
