package com.te.springsecurityj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.springsecurityj.bean.Employee;
import com.te.springsecurityj.bean.MyUserDetails;
import com.te.springsecurityj.dao.EmployeeDao;

@Service
public class EmployeeService implements UserDetailsService{

	@Autowired
	private EmployeeDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = dao.findByEmpId(username);
		return new MyUserDetails(employee);
	}

}
