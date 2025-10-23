
package com.demo.dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.demo.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	
	static List<Employee> elst;
	static {
		elst = new ArrayList<>();
		
		elst.add(new Employee("Mrunal",100,"Des"));
		elst.add(new Employee("Shivanjali",101,"Dev"));
		elst.add(new Employee("Rohan",102,"Manager"));
	}
	
	@Override
	public boolean addNewEmployee(Employee e) {
		// TODO Auto-generated method stub
		elst.add(e);
		
		return true;
	}

	@Override
	public boolean removeById(int id) {
		// TODO Auto-generated method stub
		Iterator<Employee> itr = elst.iterator();
        while (itr.hasNext()) {
            Employee e = itr.next();
            if (e.getEmpID() == id) {
                itr.remove();
                return true;
            }
        }
        return false;
	}

	@Override
	public List<Employee> displayAll() {
		// TODO Auto-generated method stub
		return elst;
	}

	@Override
	public List<Employee> displaySortedById() {
	    List<Employee> sortedList = new ArrayList<>(elst);
	    Collections.sort(sortedList); // uses compareTo()
	    return sortedList;
	}

	@Override
	public List<Employee> findByName(String empname) {
		// TODO Auto-generated method stub
		
		List<Employee> result = new ArrayList<>();
        for (Employee e : elst) {
            if (e.getEmpName().equals(empname)) {
                result.add(e);
            }
        }
        return result.isEmpty() ? null : result;
	}

	@Override
	public boolean saveAllToFile() {
		// TODO Auto-generated method stub
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.dat"))) {
            oos.writeObject(elst);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
	}


}
