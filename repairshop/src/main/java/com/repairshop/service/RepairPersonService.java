package com.repairshop.service;

import java.util.List;

import com.repairshop.dto.RepairPersonDTO;
import com.repairshop.model.RepairPerson;

public interface RepairPersonService {
	
	RepairPerson findById(int id);
	
	RepairPerson findByEmail(String email);
	
	List<RepairPerson> findBySpecialty(String specialty);
	
	List<RepairPerson> findAll();
	
	RepairPerson add(RepairPersonDTO repairPersonDTO);
	
	RepairPerson update(int repairPersonId, RepairPersonDTO repairPersonDTO);
	
	boolean remove(int repairPersonId);
	
	boolean updatePassword(int repairPersonId, String password);

}
