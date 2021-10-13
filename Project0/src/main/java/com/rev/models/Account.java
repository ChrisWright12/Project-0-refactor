package com.rev.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_id")
	private int accountId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	@Column
	private String type;

	@Column
	private int amount;


	public Account() {
	}

	public Account(int id) {
		this.accountId = id;
	}

	public Account(int id, User user, String type, int amount) {
		this.accountId = id;
		this.user = user;
		this.type = type;
		this.amount = amount;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int id) {
		this.accountId = id;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setDescription(int amount) {
		this.amount = amount;
	}


}
