package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import pojo.classes;
import pojo.classsubjectteacher;
import pojo.students;
import pojo.subjects;
import pojo.teachers;


public class hibernateConnector {
	
	public static Session  session;
	
	static {
		connectDB();
	}
	
	public static List<classes> getClasses(){
		List<classes> cls= getListFromTable("classes");
		return cls;	
	}
	
	public static List<subjects> getSubjects(){
		List<subjects> cls= getListFromTable("subjects");
		return cls;
	}
	
	public static List<teachers> getTeachers(){
		List<teachers> cls= getListFromTable("teachers");
		return cls;
	}
		
	
	public static List<students> getStudents(){
		List<students> cls= getListFromTable("students");
		return cls;
		
	}
	
	public static List<classsubjectteacher> getClasssubjectteacher(){
		List<classsubjectteacher> cls= getListFromTable("classsubjectteacher");
		return cls;
	}
	
	public static List getListFromTable(String table){
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from "+table);
		List cls= query.list();
		transaction.commit();
		return cls;
	}
	
	public static void insertClasssubjectteacher(String classes, String subject, String teacher) {
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from classes where class_title=:classname");
		query.setString("classname", classes);
		classes class1 = (classes) query.list().get(0);
		
		 query = session.createQuery("from subjects where subject_title=:subject");
		query.setString("subject", subject);
		subjects sub1 = (subjects) query.list().get(0);
		
		 query = session.createQuery("from teachers where teacher_name=:teachers");
		 query.setString("teachers", teacher);
		 teachers teach1 = (teachers) query.list().get(0);
		
		classsubjectteacher cst = new classsubjectteacher(class1,sub1,teach1);
		
		session.save(cst);
		
		transaction.commit();
		
	}

	public static void connectDB() {
	System.out.println("test");
	Configuration configuration = new Configuration().configure();
	 configuration.addAnnotatedClass(pojo.classes.class);
	 configuration.addAnnotatedClass(pojo.subjects.class);
	 configuration.addAnnotatedClass(pojo.teachers.class);
	 configuration.addAnnotatedClass(pojo.students.class);
	 configuration.addAnnotatedClass(pojo.classsubjectteacher.class);
	 
	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	SessionFactory factory = configuration.buildSessionFactory(builder.build());
	
	session = factory.openSession();
	}	
	
	
	public static void closeSession() {
		session.close();
	}

	
}












	
//
//	Query query = session.createQuery("from classes");
//	List<classes> cls= query.list();
//	
//     query = session.createQuery("from subjects");
//	 List<subjects> subs= query.list();
//	
//	 query = session.createQuery("from teachers");
//	 List<teachers> tea= query.list();
//	
//	 query = session.createQuery("from students");
//	List<students> stu= query.list();
//		
//	query = session.createQuery("from classsubjectteacher");
//	List<classsubjectteacher> sti= query.list();
//		
		
	
	
	/*
	Query query = session.createQuery("from classes");
	List<classes> cls= query.list();
	for(classes var : cls)
	{
	System.out.println(var.getClass_number());
	System.out.println(var.getClass_title().toString());
	}
	
	
	classes clss = new classes("First");
	subjects subs = new subjects("Moral Science");
	teachers teach = new teachers("Ravi");
	students stu = new students("Beena",clss);
	classsubjectteacher cst = new classsubjectteacher(clss,subs,teach);
	
	session.save(clss);
	session.save(subs);
	session.save(teach);
	session.save(stu);
	session.save(cst);
	
	*/
	
	
	
		
	


