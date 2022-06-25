package com.te.springsecurityjwtdummy.service;

import com.te.springsecurityjwtdummy.dto.Employee;

public interface EmployeeService {

	public Employee getEmp(Integer empId);

	public Employee addEmployee(Employee employee);
}
