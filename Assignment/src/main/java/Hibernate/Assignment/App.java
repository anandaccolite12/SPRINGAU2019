package Hibernate.Assignment;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.model.Course;
import com.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
	public void addStudent(Student s) {
		 List<Student> studentList= new ArrayList<Student>();
	        SessionFactory factory = new Configuration().configure().buildSessionFactory();   
	        Session session = factory.openSession();
	        session.beginTransaction();
	       
	        Integer id = (Integer)session.save(s);
	        System.out.println("Inserted Student id : "+id);
	        session.getTransaction().commit();		
	}
	
	public void addCourse(Course c) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        
        Integer id = (Integer)session.save(c);
        System.out.println("Inserted course id : "+id);
        session.getTransaction().commit();
	}
	
	public void getStudent(int id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
	    Session session = factory.openSession();
	    session.beginTransaction();
		
	    List<Student> studentList = session.createCriteria(Student.class).add( Restrictions.like("studentId", id) ).list();
		if(studentList.size()==1)
			System.out.println(studentList.get(0).getStudentName() + studentList.get(0).getStudentAge());
	}
	
	public void getCourse(int id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
	    Session session = factory.openSession();
	    session.beginTransaction();
		
	    List<Course> courseList = session.createCriteria(Course.class).add( Restrictions.like("courseId", id) ).list();
		for(Course c : courseList) {
			System.out.println(c.getCourseName() + c.getStudentId());
		}
	}
	
	public void getJoinStudentCourse() {
		List<Student> studentList;
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
	    Session session = factory.openSession();
	    session.beginTransaction();
		Criteria cr = session.createCriteria(Student.class)        		; 
		studentList= cr.list();
		
		for(Student student: studentList) {
			  System.out.println( student.getStudentName()+"|" 
			  +student.getStudentAge()+"|"
			  +student.getStudentId()+"|"
			  +(!student.getCourses().isEmpty()?student.getCourses().get(0).getCourseName()
			  :"") ); 
		}
	}
	
	
    public static void main( String[] args )
    {
    	App a =new App();
        System.out.println( "Hello World! - hi" );
        //Addding new student
        
        Student s = new Student();
        s.setStudentId(11);
        s.setStudentName("new"); 
        s.setStudentAge(23);
        a.addStudent(s);
        
        //adding new course
        Course c = new Course();
        c.setCourseId(12);
        c.setCourseName("Hibernate");
        c.setStudentId(1);
        a.addCourse(c);
        
        //getting a particular student
        a.getStudent(11);
        
        //getting a particular course
        a.getCourse(1);
        
        //join both student and course
        a.getJoinStudentCourse();
        
    }
}
