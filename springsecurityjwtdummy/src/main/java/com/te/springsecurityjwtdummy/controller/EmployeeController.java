package com.te.springsecurityjwtdummy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springsecurityjwtdummy.dto.Employee;
import com.te.springsecurityjwtdummy.jwtutil.JwtUtil;
import com.te.springsecurityjwtdummy.model.AuthenticationRequest;
import com.te.springsecurityjwtdummy.model.AuthenticationResponse;
import com.te.springsecurityjwtdummy.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private EmployeeService service;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getEmpName(), authenticationRequest.getEmpPassword()));
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("Username incorrect!!");
		}
		UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmpName());
		String token = jwtUtil.generateToken(userDetails);
		return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse(token), HttpStatus.OK);
	}

	@GetMapping("/getEmpById/{empId}")
//	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getEmpById(@PathVariable Integer empId) {
		Employee employee = service.getEmp(empId);
		if (employee != null) {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Data not found for id: " + empId, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/add")
//	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		Employee addEmployee = service.addEmployee(employee);
		if (addEmployee != null) {
			return new ResponseEntity<String>("Data inserted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Data couldn't be entered", HttpStatus.BAD_REQUEST);
		}
	}
}
