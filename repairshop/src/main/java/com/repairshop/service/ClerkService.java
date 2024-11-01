package com.repairshop.service;

import com.repairshop.dto.ClerkDTO;
import com.repairshop.model.Clerk;

public interface ClerkService {
	
	Clerk findById(int clerkId);
	
	Clerk add(ClerkDTO clerkDTO);
	
	Clerk findByEmail(String email);
	
	Clerk update(int clerkId, ClerkDTO clerkDTO);
	
	boolean remove(int clerkId);
	
	boolean updatePassword(int clerkId,String password);

}
