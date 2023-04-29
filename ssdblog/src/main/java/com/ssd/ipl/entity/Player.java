package com.ssd.ipl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cricketwickets")
public class Player {

	// id, Player, Ov, Runs, Wkts, SR, Against, Venue, MyUnknownColumn

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String Player;
	private Double Ov;
	private Integer Runs;
	private Integer Wkts;
	private Double SR;
	private String Against;
	private String Venue;

	public Player() {
		super();
	}

	public Player(Integer id, String player, Double ov, Integer runs, Integer wkts, Double sR, String against,
			String venue) {
		super();
		this.id = id;
		Player = player;
		Ov = ov;
		Runs = runs;
		Wkts = wkts;
		SR = sR;
		Against = against;
		Venue = venue;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlayer() {
		return Player;
	}

	public void setPlayer(String player) {
		Player = player;
	}

	public Double getOv() {
		return Ov;
	}

	public void setOv(Double ov) {
		Ov = ov;
	}

	public Integer getRuns() {
		return Runs;
	}

	public void setRuns(Integer runs) {
		Runs = runs;
	}

	public Integer getWkts() {
		return Wkts;
	}

	public void setWkts(Integer wkts) {
		Wkts = wkts;
	}

	public Double getSR() {
		return SR;
	}

	public void setSR(Double sR) {
		SR = sR;
	}

	public String getAgainst() {
		return Against;
	}

	public void setAgainst(String against) {
		Against = against;
	}

	public String getVenue() {
		return Venue;
	}

	public void setVenue(String venue) {
		Venue = venue;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", Player=" + Player + ", Ov=" + Ov + ", Runs=" + Runs + ", Wkts=" + Wkts + ", SR="
				+ SR + ", Against=" + Against + ", Venue=" + Venue + "]";
	}

	

}
