/**
 * 
 */
package com.example.service.controller;

import java.util.Collection;

import javax.ejb.Stateless;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.service.EmployeeService;
import com.example.service.dao.EmployeeDao;
import com.example.service.domain.Employee;

/**
 * @author sbhosale
 *
 */
@Stateless
@Controller
@RequestMapping("/employees")
public class EmployeeServiceController implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
	public  Employee getEmployee(@PathVariable int id) {
		return employeeDao.getEmployee(id);
	}

	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public Collection<Employee> listEmployee() {
		return employeeDao.listEmployees();
	}

	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String addEmployee(@RequestBody Employee emp) {
		employeeDao.addEmployee(emp);
		return "{status: 'Success'}";
	}

	@RequestMapping(value="/{id}", consumes={"application/json"}, method=RequestMethod.DELETE)
	@ResponseBody
	public Employee deleteEmployee(@PathVariable int id) {
		return employeeDao.removeEmployee(id);
	}
	
}
