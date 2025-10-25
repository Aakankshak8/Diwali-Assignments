
package com.demo.beans;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {
    private static final long serialVersionUID = 2L; 

    private int rollno;
    private String sname;
    private String course;
    private double attendancePercentage;
    private double score;
    private String grade; // Field to hold the calculated grade

    public Student() {
    	super();
    }
    
    public Student(int rollno, String sname, String course, double attendancePercentage, double score) {
        this.rollno = rollno;
        this.sname = sname;
        this.course = course;
        this.attendancePercentage = attendancePercentage;
        this.score = score;
    }
    
    // Constructor used primarily for searching/deleting by rollno 
    public Student(int rollno) { 
        this.rollno = rollno; 
    }

  

    public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public double getAttendancePercentage() {
		return attendancePercentage;
	}

	public void setAttendancePercentage(double attendancePercentage) {
		this.attendancePercentage = attendancePercentage;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
    public String toString() {
        return String.format("RollNo: %d, Name: %s, Course: %s, Attend: %.1f%%, Score: %.1f, Grade: %s", 
                             rollno, sname, course, attendancePercentage, score, 
                             grade != null ? grade : "N/A");
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return rollno == other.rollno; // Students are equal if their roll numbers match
    }

    @Override
    public int hashCode() { 
        return Objects.hash(rollno); 
    }
}
