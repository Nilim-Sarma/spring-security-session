package com.te.springbooth2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springbooth2.bean.Employee;
import com.te.springbooth2.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		Employee employee2 = service.addEmployee(employee);
		if (employee2 != null) {
			return new ResponseEntity<String>("Data saved!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Data not saved!", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getByDept/{dept}")
	public ResponseEntity<?> getByDept(@PathVariable String dept) {
		List<Employee> employee = service.findByEmpDept(dept);
		if (employee != null) {
			return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Data not found!", HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/getByName")
	public ResponseEntity<?> getByName() {
		List<Employee> employee = service.findByName();
		if (employee != null) {
			return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Data not found!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getByOrderBy")
	public ResponseEntity<?> getEmployees() {
		List<Employee> employee = service.findAllOrderByEmpName();
		if (employee != null) {
			return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Data not found!", HttpStatus.BAD_REQUEST);
		}
	}

}
