package com.repairshop.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.repairshop.dto.CustomerDTO;
import com.repairshop.model.Customer;

public interface CustomerService {
	
	Customer findById(int custId);
	
	List<Customer> findAll();
	
//	List<Customer> findByPattern(String pattern);
	
	Customer findByEmail(String email);
	
//	List<Customer> findByCreatedBy(User createdBy);
	
	 public Page<Customer> getCustomers(String search, Boolean onlyMine, int clerkId, int page, int limit);
	
	Customer add(int clerkId, CustomerDTO customerDTO);
	
	Customer update(int custId, CustomerDTO customerDTO);
	
//	Customer removeCustomer(int custID);
	
	boolean updatePassword(int custId, String password);
	
}
