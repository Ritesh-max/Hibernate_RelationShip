package com.relationship;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
	@Id
	private int id;
	
	private String address;
	
	@OneToOne(mappedBy="address")
	private Empdetails emp;

	public Empdetails getEmp() {
		return emp;
	}

	public void setEmp(Empdetails emp) {
		this.emp = emp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
