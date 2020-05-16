package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TsscAdmin;
@Repository
public interface TsscAdminRepository extends CrudRepository<TsscAdmin, Long> {
	TsscAdmin findByUsername(String user);
}
