package com.te.springbooth2.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springbooth2.bean.Employee;
import com.te.springbooth2.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao dao;
	@Autowired
	private EntityManager manager;

	@Override
	public Employee addEmployee(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public List<Employee> findByEmpDept(String dept) {
		return dao.findByEmpDept(dept);
	}

	@Override
	public List<Employee> findByName() {
//		manager.createNamedQuery("Employee.findByName");
		return dao.findByName();
	}

	@Override
	public List<Employee> findAllOrderByEmpName() {
		return dao.findAllByOrderByEmpNameDesc();
	}

}
