package com.jdc.online.job.search.entity;

import javax.persistence.Entity;

@Entity
public class Employer extends Member {

	private static final long serialVersionUID = 1L;

	private String creditcardNumber;

	public String getCreditcardNumber() {
		return creditcardNumber;
	}

	public void setCreditcardNumber(String creditcardNumber) {
		this.creditcardNumber = creditcardNumber;
	}

}
