package pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table
public class subjects {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int subject_id;
	
	private String subject_title;
	
	public subjects(String subject_title) {
		super();
		this.subject_title = subject_title;
	}
	

	public subjects() {
		super();
	}


	public String getSubject_title() {
		return subject_title;
	}
	public void setSubject_title(String subject_title) {
		this.subject_title = subject_title;
	}
	
	

}
