package com.te.springsecurityj.dao;

import org.springframework.data.repository.CrudRepository;

import com.te.springsecurityj.bean.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer>{

	public Employee findByEmpId(String userName);
}
