package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TsscStory;
import com.example.demo.model.TsscTopic;


@Repository
@Scope("singleton")
public class TsscStoryDaoImp implements TsscStoryDao {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void save(TsscStory entity) {
		entityManager.persist(entity);

	}

	@Override
	public void update(TsscStory entity) {
		entityManager.merge(entity);

	}

	@Override
	public void delete(TsscStory entity) {
		entityManager.remove(entity);

	}

	@Override
	public TsscStory findById(Long id) {
		return entityManager.find(TsscStory.class, id);
	}
	
	@Override
	public List<TsscStory> findAll() {
		String query = "Select t from TsscStory t";
		return 	entityManager.createQuery(query).getResultList();	
	}

	@Override
	public void deleteAll() {
		List<TsscStory> stories = findAll();
		for (int i = 0; i < stories.size(); i++) {
			entityManager.remove(stories.get(i));
		}
		
	}
	
	@Override
	public boolean existById(long id) {
		return (entityManager.find(TsscStory.class,id)==null)?false:true;
	}
}
