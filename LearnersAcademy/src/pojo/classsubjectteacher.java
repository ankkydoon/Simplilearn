package pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table
public class classsubjectteacher {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@OneToOne(cascade = {CascadeType.ALL})
	private classes class_number;
	@OneToOne(cascade = {CascadeType.ALL})
	private subjects subject_id;
	@OneToOne(cascade = {CascadeType.ALL})
	private teachers teacher_id;
	
	

	public classsubjectteacher() {
		super();
	}
	public classsubjectteacher(classes class_number, subjects subject_id, teachers teacher_id) {
		super();
		this.class_number=class_number;
		this.subject_id = subject_id;
		this.teacher_id = teacher_id;
	}
	public classes getClass_number() {
		return class_number;
	}
	public void setClass_number(classes class_number) {
		this.class_number = class_number;
	}
	public subjects getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(subjects subject_id) {
		this.subject_id = subject_id;
	}
	public teachers getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(teachers teacher_id) {
		this.teacher_id = teacher_id;
	}
	
}
