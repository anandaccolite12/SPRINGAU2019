package com.pkg.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentMarkReport implements Comparable, Serializable{
	private static final long serialVersionUID = -299482035708790407L;

	private transient Student student;
	private transient long totalMarks;
	private transient int percentile;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public long getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(long totalMarks) {
		this.totalMarks = totalMarks;
	}
	public int getPercentile() {
		return percentile;
	}
	public void setPercentile(int percentile) {
		this.percentile = percentile;
	}

	
	@Override
	public String toString() {
		return "StudentMarkReport [student=" + student + ", totalMarks=" + totalMarks + ", percentile=" + percentile
				+ "]";
	}
	public int compareTo(Object o) {
		StudentMarkReport o2=(StudentMarkReport)o;
		StudentMarkReport o1 = this;
		
		try {
			return compare(o2, o1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int compare(StudentMarkReport d1, StudentMarkReport d2) throws ParseException {
        if (d1.getTotalMarks() < d2.getTotalMarks())
            return -1;          
        if (d1.getTotalMarks() > d2.getTotalMarks())
            return 1;           

        if(d1.getTotalMarks()==d2.getTotalMarks()) {
            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(d1.getStudent().getDob());
            Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(d2.getStudent().getDob());
            
            if (date1.compareTo(date2) > 0)
                return -1;          
            else
                return 1;           
            
        }
        // Cannot use doubleToRawLongBits because of possibility of NaNs.
        long thisBits    = Double.doubleToLongBits(d1.getTotalMarks());
        long anotherBits = Double.doubleToLongBits(d2.getTotalMarks());

        return (thisBits == anotherBits ?  0 : // Values are equal
                (thisBits < anotherBits ? -1 : // (-0.0, 0.0) or (!NaN, NaN)
                 1));                          // (0.0, -0.0) or (NaN, !NaN)
    }
	
}
