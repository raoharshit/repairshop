package com.repairshop.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.repairshop.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
	@Query("SELECT c FROM Customer c WHERE c.name LIKE %:pattern% OR c.email LIKE %:pattern% OR c.phone LIKE %:pattern%")
    List<Customer> findByPattern(@Param("pattern") String pattern);
	
	@Query("SELECT c FROM Customer c WHERE " +
	           "(c.name LIKE %:search% OR c.email LIKE %:search%) AND " +
	           "(:onlyMine = false OR c.createdBy.id = :clerkId)")
	    Page<Customer> findBySearchAndCreatedBy(@Param("search") String search,
	    		                                @Param("onlyMine") Boolean onlyMine,
	                                            @Param("clerkId") int clerkId,
	                                            Pageable pageable);
	
//	List<Customer> findByCreatedBy(User createdBy);
	
	Customer findByEmail(String email);
	
	Customer findByPhone(String phone);
	
}
