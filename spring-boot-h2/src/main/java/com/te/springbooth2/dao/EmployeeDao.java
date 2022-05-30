package com.te.springbooth2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.te.springbooth2.bean.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

	public List<Employee> findByEmpDept(String dept);
	
	@Query("from Employee where empName like 'N%'")
	public List<Employee> findByName();
	
	public List<Employee> findAllByOrderByEmpNameDesc();

}
