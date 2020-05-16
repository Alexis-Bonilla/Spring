package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TsscAcceptanceCriteria;

@Repository
public interface TsscAcceptanceCriteriaRepository extends CrudRepository<TsscAcceptanceCriteria, Long> {

}
