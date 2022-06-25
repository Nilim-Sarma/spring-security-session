package com.te.springsecurityjwtdummy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.springsecurityjwtdummy.dao.EmployeeDao;
import com.te.springsecurityjwtdummy.dto.Employee;
import com.te.springsecurityjwtdummy.dto.MyUserDetails;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private EmployeeDao dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = dao.findByEmpName(username);
		return new MyUserDetails(employee);
	}

}
