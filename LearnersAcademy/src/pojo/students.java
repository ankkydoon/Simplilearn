package pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table
public class students {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int student_id;
	public students( String student_name, classes class_number) {
		super();
		this.student_name = student_name;
		this.class_number = class_number;
	}
	private String student_name;
	@OneToOne
	private classes class_number;
	
	
	public students() {
		super();
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public classes getClass_number() {
		return class_number;
	}
	public void setClass_number(classes class_number) {
		this.class_number = class_number;
	}
	

}
