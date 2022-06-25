package com.te.springsecurityjwtdummy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springsecurityjwtdummy.dao.EmployeeDao;
import com.te.springsecurityjwtdummy.dto.Employee;
import com.te.springsecurityjwtdummy.exception.EmployeeException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;

	@Override
	public Employee getEmp(Integer empId) {
		if (empId <= 0) {
			throw new EmployeeException("Please enter a valid Id");
		}
		return dao.findByEmpId(empId);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return dao.save(employee);
	}

}
