package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Admin {

	@Id
	private int adminId;
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "admin_id")
	private List<Card> card;
	
	
	
	public Admin(int adminId, String name, List<Card> card) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.card = card;
	}

	public Admin() {
		super();
	}
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public List<Card> getCard() {
		return card;
	}
	public void setCard(List<Card> card) {
		this.card = card;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", card=" + card + "]";
	}
	
	
}
