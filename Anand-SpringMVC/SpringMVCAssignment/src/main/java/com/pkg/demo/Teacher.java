package com.pkg.demo;

public class Teacher {
	private static final Teacher teacher=new Teacher();  
	
	private Teacher(){
		System.out.println("Teacher private constructor");
	}  
	
	public static Teacher getTeacherObject(){  
	    System.out.println("By Factory method");  
	    return teacher;  
	}  
	
	public void alert(){  
	    System.out.println("Good Morning");  
	}  
}
