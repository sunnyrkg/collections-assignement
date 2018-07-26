/**
 * 
 */
package com.training.assignment1;

/**
 * @author risabh.gupta
 *
 */
public abstract class Employee extends Person {
	
	private int empId;
	private String designation;
	public Employee(String firstname, String lastname, int age, int empId, String designation) {
		super(firstname, lastname, age);
		this.empId = empId;
		this.designation = designation;
	}
	public int getEmpId() {
		return empId;
	}
	public String getDesignation() {
		return designation;
	}
	
	
	
	

}
