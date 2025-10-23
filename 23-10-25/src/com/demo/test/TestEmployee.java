
package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Employee;
import com.demo.service.EmployeeService;
import com.demo.service.EmployeeServiceImpl;

public class TestEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		EmployeeService eservice = new EmployeeServiceImpl();
		int choice = 0;
		do {
			System.out.println(" 1. Add Employee to list\n 2. Remove Employee list\n 3. Show all Employee");
			System.out.println(" 4. Show all Employees in sorted order\n 5. Find Employee with empName\n 6. Save all Employees into file\n 7. Quit\n Choice:");

			choice = sc.nextInt();

			switch (choice) {
			case 1 -> { 
				boolean status = eservice.addNewEmployee();
				if (status) {
					System.out.println("Employee added successfully");
				} else {
					System.out.println("Not Found");
				}
			}

			case 2 -> { 
				System.out.println("Enter Employee ID to remove:");
				int id = sc.nextInt();
				boolean removed = eservice.removeEmployee(id);
				if (removed) {
					System.out.println("Employee removed successfully");
				} else {
					System.out.println("not found");
				}
			}

			case 3 -> { 
				List<Employee> elist = eservice.displayAll();
				if (elist.isEmpty()) {
					System.out.println("Empty list");
				} else {
					elist.forEach(System.out::println);
				}
			}

			case 4 -> { 
				List<Employee> sortedList = eservice.displaySortedById();
				if (sortedList.isEmpty()) {
					System.out.println("Empty list");
				} else {
					sortedList.forEach(System.out::println);
				}
			}

			case 5 -> { 
				System.out.println("Enter name to search:");
				String name = sc.next();
				List<Employee> foundList = eservice.findByName(name);
				if (foundList != null && !foundList.isEmpty()) {
					foundList.forEach(System.out::println);
				} else {
					System.out.println("Employee not found with that name");
				}
			}

			case 6 -> {
				boolean saved = eservice.saveAllToFile();
				if (saved) {
					System.out.println("All employees saved successfully to file");
				} else {
					System.out.println("Error");
				}
			}

			case 7 -> { 
				sc.close();
				System.out.println("Thank you for visiting....................");
				
			}

			default -> {
				System.out.println("Wrong choice.");
			}
			}

		}while(choice !=7);
	}

}
