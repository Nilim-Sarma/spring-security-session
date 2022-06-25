package com.te.springsecurityj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springsecurityj.dto.AuthenticationRequest;
import com.te.springsecurityj.pojo.AuthenticationResponse;
import com.te.springsecurityj.service.EmployeeService;
import com.te.springsecurityj.util.JwtUtil;

@RestController
public class DemoController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService detailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/add")
	public String admin() {
		return " <h1> Welcome admin </h1>";
	}

	@GetMapping("/get")
	public String user() {
		return " <h1> Welcome user </h1>";
	}

	@GetMapping("/home")
	public String home() {
		return " <h1> Welcome to home page </h1>";
	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> createAuthenticationToken(
			@RequestBody AuthenticationRequest authenticationRequest) {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getEmpId(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			e.printStackTrace();
		}

		UserDetails userDetails = detailsService.loadUserByUsername(authenticationRequest.getEmpId());
		String token = jwtUtil.generateToken(userDetails);
		return new ResponseEntity<>(new AuthenticationResponse(token), HttpStatus.OK);

	}

}
