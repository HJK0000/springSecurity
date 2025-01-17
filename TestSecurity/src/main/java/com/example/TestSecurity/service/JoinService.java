package com.example.TestSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.TestSecurity.dto.JoinDto;
import com.example.TestSecurity.entity.UserEntity;
import com.example.TestSecurity.repository.UserRepository;

@Service
public class JoinService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public void joinProcess(JoinDto joinDto) {
		
		
		
		UserEntity data = new UserEntity();
		data.setUsername(joinDto.getUsername());
		data.setPassword(bCryptPasswordEncoder.encode(joinDto.getPassword()));
		data.setRole("ROLE_USER");
		
		userRepository.save(data);
		
		
		
	}
}
