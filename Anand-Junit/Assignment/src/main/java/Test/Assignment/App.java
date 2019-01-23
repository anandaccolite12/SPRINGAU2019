package Test.Assignment;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.pkg.model.Student;
import com.pkg.model.StudentMarkList;
import com.pkg.model.StudentMarkReport;
import com.pkg.service.StudentService;

/**
 * Hello world!
 *
 */
public class App {
	
    public static void main( String[] args ) throws IOException, ParseException{
        StudentService ss=new StudentService();
        
        List<Student> studentList = ss.readStudentFile();
        List<StudentMarkList> studentMarkLists = ss.readStudentMarkFile(studentList);
        List<StudentMarkReport> report = ss.calculateTotalMark(studentList, studentMarkLists);
        report=ss.rankingTheStudent(report);
        ss.savingReportInFile(report);
    }
}
