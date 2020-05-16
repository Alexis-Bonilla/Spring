package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TsscGameAdmin;
@Repository
public interface TsscGameAdminRepository extends CrudRepository<TsscGameAdmin, Long> {

}
