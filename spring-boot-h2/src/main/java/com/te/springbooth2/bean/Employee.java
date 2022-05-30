package com.te.springbooth2.bean;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
//@NamedQuery(name = "Employee.findByName", 
//query = "from Employee where empName like 'N%'")
public class Employee {
	@Id
	private Integer empId;
	private String empName;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;
	private String empPassword;
	private String empDept;
}
