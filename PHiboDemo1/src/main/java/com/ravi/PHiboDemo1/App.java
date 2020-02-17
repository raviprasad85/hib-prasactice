package com.ravi.PHiboDemo1;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
    	   Configuration con=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
    	      ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	    	SessionFactory sf=con.buildSessionFactory(reg);
    	    	Session session=sf.openSession();
    	    	session.beginTransaction();
    	    	Random r=new Random();
    	    	
    	 /*   	for(int i=1;i<=50;i++){
    	    		Student s=new Student();
    	    		s.setRollno(i);
    	    		s.setName("ravi"+i);
    	    		s.setMarks(r.nextInt(100));
    	    		session.save(s);
    	    	}*/
    	    	Query q=session.createQuery("from Student");
    	    	List<Student> student= q.list();
    	    	for(Student s:student){
    	    		System.out.println(s);
    	    	}
    	    	
    	    	session.getTransaction().commit();
    	    	
    }
}
