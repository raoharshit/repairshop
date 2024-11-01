package com.repairshop.dto;

import com.repairshop.model.Customer;

public class CustomerDTO {
	
	private String name;
	private String email;
	private String phone;
	private String address;
	
	
	public CustomerDTO() {
		super();
	}


	public CustomerDTO(String name, String email, String phone, String address) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "CustomerDTO [name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address + "]";
	}
	
	public Customer getCustomer() {
		  Customer customer = new Customer();
	        customer.setName(this.name);
	        customer.setEmail(this.email);
	        customer.setPhone(this.phone);
	        customer.setAddress(address);
	        return customer;
	}
	
	
}
