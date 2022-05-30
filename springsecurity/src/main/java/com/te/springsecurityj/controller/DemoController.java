package com.te.springsecurityj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/admin")
	public String admin() {
		return " <h1> Welcome admin </h1>";
	}

	@GetMapping("/user")
	public String user() {
		return " <h1> Welcome user </h1>";
	}

	@GetMapping("/home")
	public String home() {
		return " <h1> Welcome to home page </h1>";
	}
}
