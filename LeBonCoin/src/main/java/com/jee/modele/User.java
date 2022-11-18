package com.jee.modele;

public class User {
	
	private int id;
	private String login;
	private String mail;
	private String password;
	String firstname;
	String lastname;
	String adress;
	
	public User(String login, String mail, String password, String firstname, String lastname, String adress) {
		super();
		this.login = login;
		this.mail = mail;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.adress = adress;
	}
	public User(int id, String login, String mail, String password, String firstname, String lastname, String adress) {
		super();
		this.id = id;
		this.login = login;
		this.mail = mail;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.adress = adress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
}
