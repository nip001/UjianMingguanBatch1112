package com.juaracoding.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.juaracoding.model.PenumpangModel;
import com.juaracoding.repostory.PenumpangRepository;

@Service
public class JwtPenumpangDetailsService implements UserDetailsService{

	@Autowired
	PenumpangRepository penumpangRepository;
	
	@Autowired
	PasswordEncoder pEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		PenumpangModel penumpang = penumpangRepository.findByUsername(username);
		return new User(penumpang.getUsername(), penumpang.getPassword(),
				new ArrayList<>());
	}
	

}
