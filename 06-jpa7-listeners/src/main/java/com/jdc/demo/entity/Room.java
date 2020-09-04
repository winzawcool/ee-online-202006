package com.jdc.demo.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.jdc.demo.listener.TimeEnable;

import lombok.Data;

@Entity
@Data
public class Room implements Serializable, TimeEnable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private String number;
	private Type type;
	private int price;
	
	private TimeInfo times;
	
	public enum Type {
		Single, Double, Delux, Family
	}
	
}
