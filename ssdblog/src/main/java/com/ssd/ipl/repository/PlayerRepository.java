package com.ssd.ipl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssd.ipl.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
	

}
