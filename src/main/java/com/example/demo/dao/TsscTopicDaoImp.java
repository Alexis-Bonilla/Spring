package com.example.demo.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TsscTopic;


@Repository
@Scope("singleton")
public class TsscTopicDaoImp implements TsscTopicDao {
	
	

	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public void save(TsscTopic entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(TsscTopic entity) {
		entityManager.merge(entity);

	}

	@Override
	public void delete(TsscTopic entity) {
		entityManager.remove(entity);

	}

	@Override
	public TsscTopic findById(Long id) {
		return entityManager.find(TsscTopic.class,id);
		
	}

	@Override
	public List<TsscTopic> findAll() {
		String query = "SELECT t FROM TsscTopic t";
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public List<TsscTopic> findByName(String name) {
	      String query = "Select t from TsscTopic t where t.name = :name";
	         Query q = entityManager.createQuery(query);
	         q.setParameter("name", name);
			 return q.getResultList();
	}

	@Override
	public List<TsscTopic> findByDescription(String description) {
	        String query = "SELECT t FROM TsscTopic t WHERE t.description = :description";
	        Query q = entityManager.createQuery(query);
	        q.setParameter("description", description);
			return q.getResultList();
	}

	@Override
	public List<Object[]> findTopicsByGameDateOrderedByTime(LocalDate date) {
		String query = "SELECT a,b FROM TsscTopic a RIGHT JOIN TsscGame b ON a = b.tsscTopic" + " WHERE b.scheduledDate = :date GROUP BY(a.name), b.scheduledTime ORDER BY b.scheduledTime ASC";
		Query q = entityManager.createQuery(query);
		q.setParameter("date", date);
		List<Object[]> results = q.getResultList();
		return results;

		
	}

	@Override
	public void deleteAll() {
		
		List<TsscTopic> topics= findAll();
		for (int i = 0; i < topics.size(); i++) {
			entityManager.remove(topics.get(i));
		}
		
	}

}
