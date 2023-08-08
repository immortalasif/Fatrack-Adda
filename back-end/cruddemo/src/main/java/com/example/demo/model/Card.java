package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Card {

	@Id
	private long id;
	private String cardType;
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Card(long id, String cardType) {
		super();
		this.id = id;
		this.cardType = cardType;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCardType() {
		return cardType;
	}


	public void setCardType(String cardType) {
		this.cardType = cardType;
	}


	@Override
	public String toString() {
		return "Card [id=" + id + ", cardType=" + cardType + "]";
	}
	
	
}
