
package com.demo.dao;

import com.demo.beans.Student;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    
    private static List<Student> studentList;
    
    static {
        studentList = new ArrayList<>();
    }

    @Override
    public void readData(String fname) {
        File f = new File(fname);
        if (f.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname))) {
                studentList = (List<Student>) ois.readObject(); 
                System.out.println("Data loaded: " + studentList.size() + " students.");
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error loading data: " + e.getMessage());
            }
        }
    }

    @Override
    public void writeData(String fname) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname))) {
            oos.writeObject(studentList);
            System.out.println("Data saved successfully " + fname);
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    @Override
    public boolean save(Student s) {
        return studentList.add(s);
    }

    @Override
    public boolean deleteByRollNo(int rollno) {
        return studentList.remove(new Student(rollno));
    }

    @Override
    public Student findByRollNo(int rollno) {
        int pos = studentList.indexOf(new Student(rollno));
        return pos != -1 ? studentList.get(pos) : null;
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }
}
