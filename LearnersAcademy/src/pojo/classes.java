package pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table
public class classes {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int class_number;
	public classes(String class_title) {
		super();
		this.class_title = class_title;
	}
	private String class_title;
	
	
	public classes() {
		super();
	}
	public String getClass_title() {
		return class_title;
	}
	public void setClass_title(String class_title) {
		this.class_title = class_title;
	}
	
	
}
