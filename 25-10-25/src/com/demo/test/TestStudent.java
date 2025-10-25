
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
        sservice.readFile("studentdata.txt");
        int ch = 0;
        
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println(" 1. Add New Student\n 2. Display All Students\n   ");
            System.out.println(" 3. Display Sorted by Attendance\n 4. Recalculate All Grades\n 5. Exit and Save Data\n Choice: ");
            
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
                
                case 3-> { 
                    System.out.println("\n--- Students Sorted by Attendance (Highest First) ---");
                    List<Student> sortedList = sservice.getSortedByAttendance();
                    sortedList.forEach(System.out::println);
                }
                case 4 -> { 
                    sservice.processGrades();
                }
                case 5 -> { 
                    sservice.closeApp();
                    System.out.println("Application closed and data saved.");
                }
                default -> {
                    System.out.println("Invalid choice.");
                }
            }
        } while (ch != 5);
        
        sc.close();
    }
}
