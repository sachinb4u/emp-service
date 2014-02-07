/**
 * 
 */
package com.example.service.controller;

import java.util.Collection;

import javax.ejb.Stateless;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.EmployeeDao;
import com.example.service.EmployeeService;
import com.example.service.domain.Employee;

/**
 * @author sbhosale
 *
 */
@Stateless
@Controller
@RequestMapping("/employees")
public final class EmployeeServiceController implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	public Employee getEmployee(int id) {
		return null;
	}

	@RequestMapping(method=RequestMethod.GET)
	
	public @ResponseBody Collection<Employee> listEmployee() {
		return employeeDao.listEmployees();
	}

	@RequestMapping(value="{id}",method=RequestMethod.POST)
	public String addEmployee(@PathVariable int id, @ModelAttribute Employee emp) {
		
		return "{status: 'Success'}";
	}

	public Employee deleteEmployee(int id) {
		return null;
	}

	
	
}
