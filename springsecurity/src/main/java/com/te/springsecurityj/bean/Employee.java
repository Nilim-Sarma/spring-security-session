package com.te.springsecurityj.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	private String empId;
	private String password;
	private String roles;
}
