package com.example.demo.service;

import com.example.demo.model.TsscAdmin;

public interface TsscAdminService {
	public void save(TsscAdmin nuevo);
	public void edit(TsscAdmin editado);
	public void delete(TsscAdmin delete);
	public Iterable<TsscAdmin> findAll();
	
}
