
package com.demo.test;

import com.demo.beans.Student;
import com.demo.service.StudentService;
import com.demo.service.StudentServiceImpl;
import java.util.List;
import java.util.Scanner;

public class TestStudent {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        StudentService sservice = new StudentServiceImpl();
        sservice.readFile("studentdata1.txt");
        int ch = 0;
        
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add New Student (C)");
            System.out.println("2. Display All Students (R)");
            System.out.println("3. Find Student by Roll No (R)");
            System.out.println("4. Delete Student by Roll No (D)");
            System.out.println("5. Display Sorted by Attendance (R, Sorted)");
            System.out.println("6. Recalculate All Grades (Business Rule Demo)");
            System.out.println("7. Exit and Save Data");
            System.out.print("Choice: ");
            
            if (sc.hasNextInt()) {
                ch = sc.nextInt();
            } else {
                System.err.println("Invalid input. Please enter a number.");
                sc.next(); 
                continue;
            }

            switch(ch) {
                case 1 -> { 
                    boolean status = sservice.addNewStudent();
                    if(status) {
                    	System.out.println("New Student Added");
                    }
                }
                case 2 -> { 
                    System.out.println("\n--- All Students List ---");
                    sservice.displayAllStudents().forEach(System.out::println);
                }
                case 3 -> { 
                    System.out.print("Enter Roll No to find: ");
                    int rollno = sc.nextInt();
                    Student s = sservice.findStudent(rollno);
                    if (s != null) {
                        System.out.println("Student Found: " + s);
                    } else {
                        System.out.println("Student with Roll No " + rollno + " not found.");
                    }
                }
                case 4 -> { 
                    System.out.print("Enter Roll No to delete: ");
                    int rollno = sc.nextInt();
                    if (sservice.removeStudent(rollno)) {
                        System.out.println("Student with Roll No deleted successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                }
                case 5 -> { 
                    System.out.println("\n--- Students Sorted by Attendance (Highest First) ---");
                    List<Student> sortedList = sservice.getSortedByAttendance();
                    sortedList.forEach(System.out::println);
                }
                case 6 -> { 
                    sservice.processGrades();
                }
                case 7 -> { 
                    sservice.closeApp();
                    System.out.println("Application closed and data saved.");
                }
                default -> {
                    System.out.println("Invalid choice.");
                }
            }
        } while (ch != 7);
        
        sc.close();
    }
}
