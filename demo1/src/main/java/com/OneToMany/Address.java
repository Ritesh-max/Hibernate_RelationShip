package com.OneToMany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	@Id
	private int id;

	private String AddressType;
	private String address;

	@ManyToOne
	private Empdetails empdtls;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int id, String addressType, String address) {
		super();
		this.id = id;
		AddressType = addressType;
		this.address = address;
	}
	

	public Empdetails getEmpdtls() {
		return empdtls;
	}

	public void setEmpdtls(Empdetails empdtls) {
		this.empdtls = empdtls;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressType() {
		return AddressType;
	}

	public void setAddressType(String addressType) {
		AddressType = addressType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
