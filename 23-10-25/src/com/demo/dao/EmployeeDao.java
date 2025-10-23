
package com.demo.dao;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeDao {

	boolean addNewEmployee(Employee e);

	boolean removeById(int id);

	List<Employee> displayAll();

	List<Employee> displaySortedById();

	List<Employee> findByName(String empname);

	boolean saveAllToFile();

}
