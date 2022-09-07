package com.example.musicapp.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Value("${coach.name}")
	private String coach_name;
	
	@Value("${team.name}")
	private String team_name;
	
	
	@GetMapping("/teamInfo")
	public String teamInfo() {
		return "Hello TL: "+coach_name+" team name: "+team_name;
	}
	

}
