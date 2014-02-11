/**
 * 
 */
package com.example.service.dao;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.example.service.domain.Employee;

/**
 * @author sbhosale
 *
 */
@Component
public class EmployeeDao {

	private static Map<Integer, Employee> empMap = new ConcurrentHashMap<Integer, Employee>();
	
	static{
		Employee emp1 = new Employee();
		emp1.setId(11);
		emp1.setCity("Pune");
		emp1.setName("Sachin Bhosale");
		emp1.setAge(30);
		
		Employee emp2 = new Employee();
		emp2.setId(22);
		emp2.setCity("Mumbai");
		emp2.setName("Sachin Tendulkar");
		emp2.setAge(40);
		
		empMap.put(11, emp1);
		empMap.put(22, emp2);
	}
	
	public Collection<Employee> listEmployees(){
		return  empMap.values();
	}
	
	public Employee getEmployee(int id){
		return empMap.get(id);
	}
	
	public void addEmployee(Employee emp){
		 empMap.put(emp.getId(), emp);
	}
	
	public Employee removeEmployee(int id){
		 return  empMap.remove(id) ;
	}
	
}
