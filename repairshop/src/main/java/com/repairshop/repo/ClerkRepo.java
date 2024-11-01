package com.repairshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repairshop.model.Clerk;

@Repository
public interface ClerkRepo extends JpaRepository<Clerk, Integer>{
	
    Clerk findByEmail(String email);
	
	Clerk findByPhone(String phone);

}
