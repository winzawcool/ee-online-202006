package com.jdc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String phone;
}
