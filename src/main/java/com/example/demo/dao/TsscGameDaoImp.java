package com.example.demo.dao;

import java.time.LocalDate;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TsscGame;
import com.example.demo.model.TsscTopic;

@Repository
@Scope("singleton")
public class TsscGameDaoImp implements TsscGameDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(TsscGame entity) {
		entityManager.persist(entity);

	}

	@Override
	public void update(TsscGame entity) {
		entityManager.merge(entity);

	}

	@Override
	public void delete(TsscGame entity) {
		entityManager.remove(entity);

	}

	@Override
	public TsscGame findById(Long id) {
		return entityManager.find(TsscGame.class, id);
	}

	@Override
	public List<TsscGame> findByIdTopic(Long ID) {
		String query = "SELECT t FROM TsscGame t where t.tsscTopic.id = :ID";
		Query q = entityManager.createQuery(query);
		q.setParameter("ID",ID);
		return q.getResultList();
	}

	@Override
	public List<TsscGame> findByName(String name) {
        String query = "SELECT t FROM TsscGame t WHERE t.name = :name";
        Query q = entityManager.createQuery(query);
        q.setParameter("name", name);
		 return q.getResultList();
	}

	@Override
	public List<TsscGame> findByDescription(String description) {
        String query = "SELECT t FROM TsscGame t WHERE t.DESCRIPTION = :description";
        Query q = entityManager.createQuery(query);
        q.setParameter("description", description);
		 return q.getResultList();
	}

	@Override
	public List<TsscGame> findByDateRange(LocalDate date1, LocalDate date2) {
		String query = "SELECT t FROM TsscGame t where t.scheduledDate between :date1 and :date2";
		Query q = entityManager.createQuery(query);
		q.setParameter("date1", date1);
		q.setParameter("date2", date2);
		return q.getResultList();
	}

	@Override
	public List<TsscGame> findByDateTimeRange(LocalDate date1, LocalTime time1, LocalTime time2) {
		String query = "SELECT t FROM TsscGame t where t.scheduledDate = :date1 and  t.scheduledTime between :time1 and :time2";
		Query q = entityManager.createQuery(query);
		q.setParameter("time1", time1);
		q.setParameter("time2", time2);
		return q.getResultList();
	}

	@Override
	public List<TsscGame> findByDateStoryTime(LocalDate date1) {
		String query = "SELECT a FROM TsscGame a WHERE a.scheduledDate ='"+date1+"' AND (size(a.tsscStories)<10 " + "OR size(a.tsscTimecontrols) = 0)";
		Query q = entityManager.createQuery(query);
		@SuppressWarnings("unchecked")
		List<TsscGame> results = q.getResultList();
		return results;
	}

	@Override
	public List<TsscGame> findByTopicDescription(String string) {
		
		String query = "SELECT t FROM TsscGame t where t.tsscTopic.description = :description";
		Query q = entityManager.createQuery(query);
		q.setParameter("description", string);
		return q.getResultList();
		 
		 
		 
	}
	
	
	public List<TsscGame> findAll() {
		String query = "SELECT t FROM TsscGame t";
		return entityManager.createQuery(query).getResultList();
	}
	

	@Override
	public void deleteAll() {
		List<TsscGame> games = findAll();
		
		for (int i = 0; i < games.size(); i++) {
			entityManager.remove(games.get(i));
		}
		
		
	}

}
