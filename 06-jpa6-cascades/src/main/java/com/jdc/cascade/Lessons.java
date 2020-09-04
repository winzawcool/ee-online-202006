package com.jdc.cascade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.ElementCollection;
import javax.persistence.ManyToOne;
import static javax.persistence.FetchType.EAGER;

@Data
@Entity
public class Lessons implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private String title;
	
	@ManyToOne
	private Course course;
	
	@ElementCollection(fetch = EAGER)
	private List<String> lectures = new ArrayList<>();
}
