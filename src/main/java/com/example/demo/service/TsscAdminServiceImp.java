package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TsscAdmin;
import com.example.demo.repository.TsscAdminRepository;



@Service
public class TsscAdminServiceImp implements TsscAdminService{
	
	@Autowired
	private TsscAdminRepository repository;
	


	@Override
	public TsscAdmin save(TsscAdmin nuevo) {
		return repository.save(nuevo);
	}

	@Override
	public TsscAdmin edit(TsscAdmin editado) {
		return repository.save(editado);
	}

	@Override
	public void delete(TsscAdmin delete) {
		repository.delete(delete);
	}
	
	

}
