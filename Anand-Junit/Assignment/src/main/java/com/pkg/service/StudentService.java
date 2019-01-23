package com.pkg.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pkg.model.Student;
import com.pkg.model.StudentMarkList;
import com.pkg.model.StudentMarkReport;

public class StudentService {

	public List<Student> readStudentFile() throws IOException {
		List<Student> studentList = new ArrayList<Student>();
		
		BufferedReader in = new BufferedReader(new FileReader("D:\\Junit\\student.txt"));
        String s;
        
        int i=0;
        while((s = in.readLine()) != null){
            String[] var = s.split(",");
            studentList.add(new Student());
            studentList.get(i).setStudentCode(var[0]);
            studentList.get(i).setStudentName(var[1]);
            studentList.get(i).setDob(var[2]);
            System.out.println(studentList.get(i));
            i++;
        }
        
        return studentList; 
	}
	
	public List<StudentMarkList> readStudentMarkFile(List<Student> studentList) throws NumberFormatException, IOException {
		List<StudentMarkList> studentMarkLists = new ArrayList<StudentMarkList>();
		
        BufferedReader inn = new BufferedReader(new FileReader("D:\\Junit\\studentmark.txt"));
        String s;
        int i=0;
        
        while((s = inn.readLine()) != null){
            String[] var = s.split(",");
            Student student=null;
            
            for(Student stu:studentList) {
            	if(var[0].equals(stu.getStudentCode())) {
            		studentMarkLists.add(new StudentMarkList());
    	            studentMarkLists.get(i).setStudent(stu);
    	            Map<String, Integer> mark = new HashMap<String, Integer>();
    	            mark.put(var[1], Integer.parseInt(var[2]));
    	            studentMarkLists.get(i).setSubjectMarks(mark);
    	            System.out.println(studentMarkLists.get(i));
    	            i++;
            	}
            }
	        
        }
        return studentMarkLists;
	}
	
	
	public List<StudentMarkReport> calculateTotalMark(List<Student> studentList, List<StudentMarkList> markList) {
		List<StudentMarkReport> reportList=new ArrayList<StudentMarkReport>();
		int i=0;
		for(Student student:studentList) {
			int mark = 0;
			reportList.add(new StudentMarkReport());
			for(StudentMarkList studentMarkList:markList) {
				if(student.getStudentCode().equals(studentMarkList.getStudent().getStudentCode())){
					for(Map.Entry<String, Integer> entry : studentMarkList.getSubjectMarks().entrySet()) {
						mark=mark+entry.getValue();
					}
				}
			}
			reportList.get(i).setStudent(student);
			reportList.get(i).setTotalMarks(mark);
			System.out.println(reportList.get(i));
			i++;
		}
		
		Collections.sort(reportList);
		
		System.out.println("After sorting");
		for(StudentMarkReport s:reportList) {
			System.out.println(s);
		}
		
		return reportList;
		
	}
	
	
	
	public List<StudentMarkReport> rankingTheStudent(List<StudentMarkReport> reportList) {
		Long maxTotal = reportList.get(0).getTotalMarks();
		for(StudentMarkReport report:reportList) {
			report.setPercentile((int)(report.getTotalMarks()*100/maxTotal));
		}
		
		System.out.println("\nAfter percentile\n");
		for(StudentMarkReport s:reportList) {
			System.out.println(s);
		}
		return reportList;
	}
	
	public void savingReportInFile(List<StudentMarkReport> reportList) throws FileNotFoundException {		
//			FileOutputStream fos = new FileOutputStream("D:\\Junit\\studentReport.txt");
		PrintWriter pw = new PrintWriter(new File("D:\\Junit\\studentReport.csv"));
        
		StringBuilder sb1 = new StringBuilder();
        sb1.append("Name		");
        sb1.append("DOB				");
        sb1.append("TotalMark		");
        sb1.append("Percentile		");
        sb1.append('\n');
        pw.write(sb1.toString());
        
		for(StudentMarkReport s : reportList) {
			StringBuilder sb = new StringBuilder();
			sb.append(s.getStudent().getStudentName()+"		");
	        sb.append(s.getStudent().getDob()+"		");
	        sb.append(s.getTotalMarks()+"				");
	        sb.append(s.getPercentile());
	        sb.append('\n');
	
	        pw.write(sb.toString());
	    }
        pw.close();
        System.out.println("CSV output file created!");
	}
}
