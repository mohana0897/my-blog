package com.ssd.ipl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssd.ipl.entity.Player;
import com.ssd.ipl.repository.PlayerRepository;

@Service

public class IplService {

	@Autowired
	private	PlayerRepository playerRepository;
	
	//private ModelMapper modelMapper;
	
	public List<Player> getAllPlayers(){
		
		return playerRepository.findAll();
	}
	
}
