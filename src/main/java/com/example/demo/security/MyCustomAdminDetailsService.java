package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TsscAdminDao;
import com.example.demo.model.TsscAdmin;
import com.example.demo.repository.TsscAdminRepository;


@Service
public class MyCustomAdminDetailsService implements UserDetailsService {

	@Autowired
	private TsscAdminRepository adminRepository;
	
	@Autowired
	public MyCustomAdminDetailsService(TsscAdminRepository adminRepository) {		
		this.adminRepository = adminRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TsscAdmin tsscAdmin = adminRepository.findByUsername(username);
		if (tsscAdmin != null) {
			User.UserBuilder builder = User.withUsername(username).password(tsscAdmin.getPassword()).roles(tsscAdmin.getSuperAdmin());
			return builder.build();
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
	}

}
