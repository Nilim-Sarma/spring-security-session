package com.te.springsecurityj.pojo;

import lombok.AllArgsConstructor;

import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationResponse {
	private final String jwt;
}
