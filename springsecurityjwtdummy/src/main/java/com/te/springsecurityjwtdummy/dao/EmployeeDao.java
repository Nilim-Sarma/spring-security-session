package com.te.springsecurityjwtdummy.dao;

import org.springframework.data.repository.CrudRepository;

import com.te.springsecurityjwtdummy.dto.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

	public Employee findByEmpId(Integer empId);

	public Employee findByEmpName(String empName);
}
