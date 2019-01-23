package com.pkg.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.pkg.model.Student;
import com.pkg.model.StudentMarkList;
import com.pkg.model.StudentMarkReport;
import com.pkg.service.StudentService;

public class TestStudentServices {
	public 	StudentService s = new StudentService();
	
	@BeforeClass
	public static void beforeTestStatic() {
		System.out.println("Before testcase - Static");
	}
	
	@AfterClass
	public static void afterTestStatic() {
		System.out.println("After testcase - Static");
	}
	
	@Before
	public void beforeTest() {
		System.out.println("Before testcase");
	}
	
	@After
	public void afterTest() {
		System.out.println("After testcase");
	}
	
	@Test
	public void testReadStudentFileMethod() throws IOException {
		List<Student> students = s.readStudentFile();
		assertEquals(4, students.size());
	}
	
	@Test
	public void testReadStudentMarkFileMethod() throws IOException {
		List<StudentMarkList> studentsMark = s.readStudentMarkFile(s.readStudentFile());
		assertEquals(20, studentsMark.size());
	}
	
	@Test
	public void testStudentTotalMarkMethod() throws IOException{
		List<StudentMarkReport> studentsMark = s.calculateTotalMark(s.readStudentFile(),s.readStudentMarkFile(s.readStudentFile()));
		assertEquals(s.readStudentFile().size(), studentsMark.size());
	}
	
	@Test(timeout=1000)
	public void testRankingTheStudentMethod() throws IOException {
		List<StudentMarkReport> studentsMark = s.rankingTheStudent(s.calculateTotalMark(s.readStudentFile(),s.readStudentMarkFile(s.readStudentFile())));
		assertEquals(4, studentsMark.size());
	}
	
	@Test(expected = FileNotFoundException.class)
	public void testOutput() throws NumberFormatException, IOException {
		List<StudentMarkReport> studentsMark = s.rankingTheStudent(s.calculateTotalMark(s.readStudentFile(),s.readStudentMarkFile(s.readStudentFile())));
		
		StudentService serviceMock = Mockito.mock(StudentService.class);
		Mockito.doThrow(FileNotFoundException.class).when(serviceMock).savingReportInFile(studentsMark);
		
		serviceMock.savingReportInFile(studentsMark);
	}
	
	@Test
	public void writeFileTest() throws NumberFormatException, IOException {
		File file = new File("D:\\Junit\\studentReport.csv");
		List<StudentMarkReport> studentsMark = s.rankingTheStudent(s.calculateTotalMark(s.readStudentFile(),s.readStudentMarkFile(s.readStudentFile())));
		s.savingReportInFile(studentsMark);
		System.out.println(file.length());
		assertNotEquals(0, file.length());
	}
	
}
