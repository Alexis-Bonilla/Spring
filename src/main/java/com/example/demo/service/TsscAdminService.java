package com.example.demo.service;

import com.example.demo.model.TsscAdmin;

public interface TsscAdminService {
	public TsscAdmin save(TsscAdmin nuevo);
	public TsscAdmin edit(TsscAdmin editado);
	public void delete(TsscAdmin delete);
	
}
