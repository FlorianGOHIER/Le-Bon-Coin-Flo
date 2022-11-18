package com.jee.modele;

public class Item {
	
	int id;
	int userId;
	String title;
	String description;
	float price;
	String dateCreation;
	String dateModification;
	
	public Item(int id, int userId, String title, String description, float price, String dateCreation,
			String dateModification) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.description = description;
		this.price = price;
		this.dateCreation = dateCreation;
		this.dateModification = dateModification;
	}
	public Item(int userId, String title, String description, float price) {
		super();
		this.userId = userId;
		this.title = title;
		this.description = description;
		this.price = price;
	}
	public Item(int id, int userId, String title, String description, float price) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.description = description;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getDateModification() {
		return dateModification;
	}
	public void setDateModification(String dateModification) {
		this.dateModification = dateModification;
	}
}
