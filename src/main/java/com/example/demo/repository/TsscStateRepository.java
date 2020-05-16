package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TsscState;
@Repository
public interface TsscStateRepository extends CrudRepository<TsscState, Long> {

}
