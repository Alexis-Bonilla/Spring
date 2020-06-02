package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import com.example.demo.model.TsscAdmin;

@Repository
@Scope("singleton")
public class TsscAdminDaoImp implements TsscAdminDao {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void save(TsscAdmin entity) {
		entityManager.persist(entity);

	}

	@Override
	public void update(TsscAdmin entity) {
		entityManager.merge(entity);

	}

	@Override
	public void delete(TsscAdmin entity) {
		entityManager.remove(entity);

	}

	@Override
	public TsscAdmin findById(Long id) {
		return entityManager.find(TsscAdmin.class, id);
	}
	
	
	@Override
	public List<TsscAdmin> findAll() {
		String query = "SELECT t FROM TsscAdmin t";
		return 	entityManager.createQuery(query).getResultList();
	}

	@Override
	public void deleteAll() {
		List<TsscAdmin> admins = findAll();
		for (int i = 0; i < admins.size(); i++) {
			entityManager.remove(admins.get(i));
		}
		
	}

	@Override
	public TsscAdmin findByUser(String username) {
		String jpql = "SELECT a FROM TsscAdmin a WHERE a.user = '" +username +"'";
		return (TsscAdmin) entityManager.createQuery(jpql).getSingleResult();
	}

}
