package com.example.TestSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.TestSecurity.dto.JoinDto;
import com.example.TestSecurity.service.JoinService;

@Controller
public class JoinController {

	@Autowired
	private JoinService joinService;
	
	
	@GetMapping("/join")
	public String joinP() {
		
		return "join";
	}
	
	@PostMapping("/joinProc")
	public String joinProc(JoinDto joinDto) {
		
		System.out.println(joinDto.getUsername());
		
		joinService.joinProcess(joinDto);
		
		
		return "redirect:/login";
		
	}
}
