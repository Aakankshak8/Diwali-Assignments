package com.demo.beans;

public class Student {
	private int rollno;
	private String sname;
	private String course;
	private double attendance_percentage;
	private double score;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int rollno, String sname, String course, double attendance_percentage, double score) {
		super();
		this.rollno = rollno;
		this.sname = sname;
		this.course = course;
		this.attendance_percentage = attendance_percentage;
		this.score = score;
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
	public double getAttendance_percentage() {
		return attendance_percentage;
	}
	public void setAttendance_percentage(double attendance_percentage) {
		this.attendance_percentage = attendance_percentage;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", sname=" + sname + ", course=" + course + ", attendance_percentage="
				+ attendance_percentage + ", score=" + score + "]";
	}
	
	
	

}
