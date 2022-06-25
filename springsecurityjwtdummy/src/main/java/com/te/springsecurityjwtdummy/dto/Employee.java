package com.te.springsecurityjwtdummy.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "employee_primary_info")
public class Employee {
	@Id
	private Integer empId;
	private String empName;
	private String empPassword;
	private String empRoles;
}
