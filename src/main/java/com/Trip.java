package com;

public class Trip {
	
	private int TR_id;
	private String TR_departureDate;
	private int TR_period;
	private String TR_destination;
	private int freeSits;
	private String DR_firstname;
	private String DR_lastname;
	
	
	public int getFreeSits() {
		return freeSits;
	}
	public void setFreeSits(int freeSits) {
		this.freeSits = freeSits;
	}
	public String getDR_firstname() {
		return DR_firstname;
	}
	public void setDR_firstname(String DR_firstname) {
		this.DR_firstname = DR_firstname;
	}
	public String getDR_lastname() {
		return DR_lastname;
	}
	public void setDR_lastname(String DR_lastname) {
		this.DR_lastname = DR_lastname;
	}
	
	public Trip(int tR_id, String tR_departureDate, int tR_period, String tR_destination, String dR_firstname,
			String dR_lastname) {
		super();
		TR_id = tR_id;
		TR_departureDate = tR_departureDate;
		TR_period = tR_period;
		TR_destination = tR_destination;
		DR_firstname = dR_firstname;
		DR_lastname = dR_lastname;
	}
	
	
	
	public Trip(int tR_id, String tR_departureDate, int tR_period, String tR_destination, int freeSits,
			String dR_firstname, String dR_lastname) {
		super();
		TR_id = tR_id;
		TR_departureDate = tR_departureDate;
		TR_period = tR_period;
		TR_destination = tR_destination;
		this.freeSits = freeSits;
		DR_firstname = dR_firstname;
		DR_lastname = dR_lastname;
	}
	public void setTR_id(int TR_id) {
		this.TR_id = TR_id;
	}
	public void setTR_departureDate(String TR_departureDate) {
		this.TR_departureDate = TR_departureDate;
	}
	public void setTR_period(int tR_period) {
		this.TR_period = tR_period;
	}
	public void setTR_destination(String TR_destination) {
		this.TR_destination = TR_destination;
	}
	
	
	
	public int getTR_id() {
		return TR_id;
	}
	
	public String getTR_departureDate() {
		return TR_departureDate;
	}

	public int getTR_period() {
		return TR_period;
	}

	public String getTR_destination() {
		return TR_destination;
	}

	
	

}
