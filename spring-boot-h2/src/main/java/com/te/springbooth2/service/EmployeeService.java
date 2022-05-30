package com.te.springbooth2.service;

import java.util.List;

import com.te.springbooth2.bean.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);

	public List<Employee> findByEmpDept(String dept);

	public List<Employee> findByName();

	public List<Employee> findAllOrderByEmpName();
}
