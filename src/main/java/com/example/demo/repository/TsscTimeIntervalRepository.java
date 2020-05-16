package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TsscTimeInterval;
@Repository
public interface TsscTimeIntervalRepository extends CrudRepository<TsscTimeInterval, Long> {

}
