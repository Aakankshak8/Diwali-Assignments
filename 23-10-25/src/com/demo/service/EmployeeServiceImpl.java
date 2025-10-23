package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Employee;
import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao edao;
	
	public EmployeeServiceImpl(){
		super();
		edao=new EmployeeDaoImpl();
	}
	
	@Override
	public boolean addNewEmployee() {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the name of the Employee");
		String empName=sc.nextLine();
		
		System.out.println("Enter the Employee ID");
		int empID =sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter the Role ");
		String empRole=sc.nextLine();
		
		Employee e=new Employee(empName,empID,empRole);
		
		return edao.addNewEmployee(e);
	}

	@Override
	public boolean removeEmployee(int id) {
		// TODO Auto-generated method stub
		return edao.removeById(id);
	}

	@Override
	public List<Employee> displayAll() {
		// TODO Auto-generated method stub
		return edao.displayAll();
	}

	@Override
	public List<Employee> displaySortedById() {
		// TODO Auto-generated method stub
		return edao.displaySortedById();
	}

	@Override
	public List<Employee> findByName(String empname) {
		// TODO Auto-generated method stub
		return edao.findByName(empname);
	}

	@Override
	public boolean saveAllToFile() {
		// TODO Auto-generated method stub
		
		return edao.saveAllToFile();
	}

}