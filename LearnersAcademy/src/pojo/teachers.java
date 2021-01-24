package pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table
public class teachers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int teacher_id;
	private String teacher_name;
	
	
	public teachers(String teacher_name) {
		super();
		this.teacher_name = teacher_name;
	}
	
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public teachers() {
		super();
	}
	

}
