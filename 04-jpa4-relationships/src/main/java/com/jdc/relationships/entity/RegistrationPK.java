package com.jdc.relationships.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class RegistrationPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "student_id")
	private int StudentId;
	@Column(name = "class_id")
	private int classId;
}
