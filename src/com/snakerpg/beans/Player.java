package com.snakerpg.beans;

/* Bean du client
 * 
 *   
 *  */



public class Player{
	
	String name;
	String firstname;
	String adress;
	String telephoneNumber;
	String emailadress;
	String mdp;
	
	

	public Player() {
		
		
	}


	/* Getters and Setters on the client */
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFirstName() {
		return firstname;
	}


	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public String getTelephoneNumber() {
		return telephoneNumber;
	}


	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}


	
	
	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getEmailadress() {
		return emailadress;
	}


	public void setEmailadress(String emailadress) {
		this.emailadress = emailadress;
	}


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	
}