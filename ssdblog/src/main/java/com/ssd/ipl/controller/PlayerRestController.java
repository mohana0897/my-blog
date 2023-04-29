package com.ssd.ipl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.ipl.entity.Player;
import com.ssd.ipl.service.IplService;

@RestController
@RequestMapping("ipl/api")
public class PlayerRestController {
	
	@Autowired
	private IplService iplService;
	
	
	@GetMapping("players")
	public ResponseEntity<?> getAllPlayers(){
		
		System.out.println("ssssss"+iplService.getAllPlayers());
		
	return new ResponseEntity<List<Player>>	(iplService.getAllPlayers(),HttpStatus.OK);
				

		
	}
	
	
	
}
