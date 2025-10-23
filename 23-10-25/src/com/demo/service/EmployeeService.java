
package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeService {

	boolean addNewEmployee();

	boolean removeEmployee(int id);

	List<Employee> displayAll();

	List<Employee> displaySortedById();

	List<Employee> findByName(String name);

	boolean saveAllToFile();

}
