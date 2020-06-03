package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TsscTimecontrol;

@Repository
@Scope("singleton")
public class TsscTimeControlDaoImp implements TsscTimeControlDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(TsscTimecontrol entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(TsscTimecontrol entity) {
		entityManager.merge(entity);
		
	}

	@Override
	public void delete(TsscTimecontrol entity) {
		entityManager.remove(entity);
	}

	@Override
	public TsscTimecontrol findById(long id) {
		
		return entityManager.find(TsscTimecontrol.class, id);
	}

	@Override
	public List<TsscTimecontrol> findAll() {
		String jpql = "SELECT a "
				+ "FROM TsscTimecontrol a";
		return 	entityManager.createQuery(jpql).getResultList();	
	}
	
	

}
