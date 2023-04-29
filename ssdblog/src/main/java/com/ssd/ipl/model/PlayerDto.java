package com.ssd.ipl.model;

public class PlayerDto {

	private Integer id;
	private String player;
	private Double ov;
	private Integer runs;
	private Integer wkts;
	private Double sr;
	private String against;
	private String venue;

	public PlayerDto() {
		super();
	}

	@Override
	public String toString() {
		return "PlayerDto [id=" + id + ", player=" + player + ", ov=" + ov + ", runs=" + runs + ", wkts=" + wkts
				+ ", sr=" + sr + ", against=" + against + ", venue=" + venue + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public Double getOv() {
		return ov;
	}

	public void setOv(Double ov) {
		this.ov = ov;
	}

	public Integer getRuns() {
		return runs;
	}

	public void setRuns(Integer runs) {
		this.runs = runs;
	}

	public Integer getWkts() {
		return wkts;
	}

	public void setWkts(Integer wkts) {
		this.wkts = wkts;
	}

	public Double getSr() {
		return sr;
	}

	public void setSr(Double sr) {
		this.sr = sr;
	}

	public String getAgainst() {
		return against;
	}

	public void setAgainst(String against) {
		this.against = against;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public PlayerDto(Integer id, String player, Double ov, Integer runs, Integer wkts, Double sr, String against,
			String venue) {
		super();
		this.id = id;
		this.player = player;
		this.ov = ov;
		this.runs = runs;
		this.wkts = wkts;
		this.sr = sr;
		this.against = against;
		this.venue = venue;
	}

}
