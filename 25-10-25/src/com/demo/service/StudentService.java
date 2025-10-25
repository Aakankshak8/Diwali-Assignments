package com.demo.service;

import java.util.List;

import com.demo.beans.Student;

public interface StudentService {

	void readFile(String string);

	boolean addNewStudent();

	Iterable<Student> displayAllStudents();

//	Student findStudent(int rollno);
//
//	boolean removeStudent(int rollno);

	List<Student> getSortedByAttendance();

	void processGrades();

	void closeApp();

}
