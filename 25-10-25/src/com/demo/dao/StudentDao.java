package com.demo.dao;

import java.util.List;

import com.demo.beans.Student;

public interface StudentDao {

	boolean save(Student student);

	void readData(String fname);

	List<Student> findAll();

//	boolean deleteByRollNo(int rollno);
//
//	Student findByRollNo(int rollno);

	void writeData(String fILE_NAME);

}
