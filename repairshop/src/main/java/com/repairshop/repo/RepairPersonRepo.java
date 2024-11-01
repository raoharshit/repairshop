package com.repairshop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repairshop.model.RepairPerson;

@Repository
public interface RepairPersonRepo extends JpaRepository<RepairPerson, Integer> {
	
	List<RepairPerson> findBySpecialty(String specialty);
	
    RepairPerson findByEmail(String email);
	
	RepairPerson findByPhone(String phone);

}
