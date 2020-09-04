package com.jdc.cascade;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import static javax.persistence.CascadeType.REMOVE;

@Entity
@Data
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private String name;
	private int fees;
	
	@OneToMany(mappedBy = "course", cascade = { PERSIST, MERGE, REMOVE })
	private List<Lessons> lessons = new ArrayList<>();
	
	public void addLesson(Lessons lesson) {
		lesson.setCourse(this);
		lessons.add(lesson);
	}
	
	public void removeLesson(Lessons lesson) {
		lesson.setCourse(null);
		lessons.remove(lesson);
	}
}
