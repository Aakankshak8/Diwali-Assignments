
package com.demo.service;

import com.demo.beans.Student;
import com.demo.dao.StudentDao;
import com.demo.dao.StudentDaoImpl;
import com.demo.beans.*;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentServiceImpl implements StudentService {
    
    private StudentDao sdao = new StudentDaoImpl(); 
    private Scanner sc = new Scanner(System.in);
    private final String FILE_NAME = "studentdata.txt"; 
    
    private String calculateGrade(Student student) throws LowAttendanceException {
        if (student.getAttendancePercentage() < 60.0) {
            throw new LowAttendanceException("Grade blocked due to attendance < 60%.");
        }
        double score = student.getScore();
        if (score >= 90) return "A";
        else if (score >= 80) return "B";
        else if (score >= 70) return "C";
        else return "F";
    }
    
    private void createInitialData() {
    	sdao.save(new Student(101, "Aakanksha", "CS", 92.5, 94.0));
    	sdao.save(new Student(102, "Mrunal", "IT", 78.0, 81.5));
    	sdao.save(new Student(103, "Snehal", "ECE", 67.0, 70.0));
    	sdao.save(new Student(104, "Pooja", "ME", 88.5, 85.0));
    	sdao.save(new Student(105, "Komal", "CE", 56.0, 60.0));   
    	sdao.save(new Student(106, "Tejaswini", "AI", 95.0, 97.0));
    	sdao.save(new Student(107, "Vaishnavi", "DS", 72.0, 75.5)); 
    	sdao.save(new Student(108, "Rutuja", "EE", 64.0, 68.0));
    	sdao.save(new Student(109, "Sayali", "IT", 84.0, 89.0));
    	sdao.save(new Student(110, "Shruti", "CS", 91.0, 90.0)); 
    }
    

    @Override
    public void readFile(String fname) {
        sdao.readData(fname);
        if (sdao.findAll().isEmpty()) {
            System.out.println("\n Creating initial 10 students ");
            createInitialData();
            processGrades(); 
            System.out.println("Initial data ready.  \n");
        }
    }

    @Override
    public boolean addNewStudent() {
        System.out.print("Enter Roll No: ");
        int rollno = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Name: ");
        String sname = sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();
        System.out.print("Enter Attendance Percentage: ");
        double attendance = sc.nextDouble();
        System.out.print("Enter Score: ");
        double score = sc.nextDouble();
        
        Student newStudent = new Student(rollno, sname, course, attendance, score);
        
        try {
            newStudent.setGrade(calculateGrade(newStudent));
        } catch (LowAttendanceException e) {
            newStudent.setGrade("N/A (LOW ATT)");
            System.err.println("Warning: " + e.getMessage());
        }
        
        return sdao.save(newStudent);
    }
    
    @Override
    public void processGrades() {
        System.out.println("--- Recalculating Grades ---");
        for (Student s : sdao.findAll()) {
            try {
                s.setGrade(calculateGrade(s));
            } catch (LowAttendanceException e) {
                s.setGrade("N/A (LOW ATT)");
                System.err.println("FAILED for " + s.getSname() + ": " + e.getMessage());
            }
        }
    }

    @Override
    public List<Student> getSortedByAttendance() {
        List<Student> sortedList = sdao.findAll();
        sortedList.sort(Comparator.comparing(Student::getAttendancePercentage).reversed());
        return sortedList;
    }
    

    @Override
    public List<Student> displayAllStudents() {
        return sdao.findAll();
    }
    
    @Override
    public void closeApp() {
        sdao.writeData(FILE_NAME);
    }
}
