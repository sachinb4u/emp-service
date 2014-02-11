/**
 * 
 */
package com.example.service;

import java.util.Collection;

import javax.ejb.Remote;

import com.example.service.domain.Employee;

/**
 * @author sbhosale
 *
 */
@Remote
public interface EmployeeService {
	
	
	Employee getEmployee(int id);
	Collection<Employee> listEmployee();
	String addEmployee(Employee emp);
	Employee deleteEmployee(int id);

}
