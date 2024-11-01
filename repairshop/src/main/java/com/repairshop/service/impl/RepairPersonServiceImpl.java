package com.repairshop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repairshop.dto.RepairPersonDTO;
import com.repairshop.model.RepairPerson;
import com.repairshop.repo.RepairPersonRepo;
import com.repairshop.service.RepairPersonService;

@Service
public class RepairPersonServiceImpl implements RepairPersonService{
	
	@Autowired
	RepairPersonRepo repairPersonRepo;
	
	@Override
	public RepairPerson findById(int id) {
		Optional<RepairPerson> optRepairPerson = repairPersonRepo.findById(id);
		if(optRepairPerson.isEmpty()) {
			//throws new Exception("Repairperson with " + id + " is not present");
//			return null;
		}
		return optRepairPerson.get();
	}
	
	@Override
	public RepairPerson findByEmail(String email) {
		RepairPerson repairPerson = repairPersonRepo.findByEmail(email);
		if(repairPerson == null) {
			//throw new Exception("RepairPeron not found");
			return null;
		}
		
		return repairPerson;
	}

	@Override
	public List<RepairPerson> findBySpecialty(String specialty) {
		List<RepairPerson> list = repairPersonRepo.findBySpecialty(specialty);
		return list;
	}

	@Override
	public RepairPerson add(RepairPersonDTO repairPersonDTO) {
		// TODO Auto-generated method stub
		if(repairPersonRepo.findByEmail(repairPersonDTO.getEmail()) != null ) {
			// throw new Exception(Customer with same email is already present)
			return null;
		}
		
		RepairPerson repairPerson = repairPersonDTO.getRepairPerson();
		
		//pasword hasing code
		//String hashedPassword = hasPassword(repairPerson.getHashedPassword());
		//repairPerson.setHashedPassword(hashedPassword);
		RepairPerson saved = repairPersonRepo.save(repairPerson);
		
		return saved;
	}

	@Override
	public RepairPerson update(int repairPersonId, RepairPersonDTO repairPersonDTO) {
		// TODO Auto-generated method stub
		Optional<RepairPerson> optRepairPerson = repairPersonRepo.findById(repairPersonId);
		
		if(optRepairPerson.isEmpty()) {
			//throw new Exception("RepairPerson not found");
			return null;
		}
		RepairPerson repairPerson = optRepairPerson.get();
		repairPerson.setName(repairPersonDTO.getName());
		repairPerson.setPhone(repairPersonDTO.getPhone());
		repairPerson.setAddress(repairPersonDTO.getAddress());
		RepairPerson updated = repairPersonRepo.save(repairPerson);
		
		return updated;
	}

	@Override
	public boolean updatePassword(int id, String password) {
		Optional<RepairPerson> optRepairPerson = (repairPersonRepo.findById(id));
		
		if(optRepairPerson.isEmpty()) {
			//throw new Exception("RepairPerson not found");
			return false;
		}
		RepairPerson repairPerson = optRepairPerson.get();
		//password hashing code
		//String hashedPassword = hashPassword(password);
		//repairPerson.setHashedPassword(hashedPassword);
		repairPersonRepo.save(repairPerson);
		return true;
		
		
	}

	@Override
	public List<RepairPerson> findAll() {
		// TODO Auto-generated method stub
		List<RepairPerson> list = repairPersonRepo.findAll();
		return list;
	}

	@Override
	public boolean remove(int repairPersonId) {
		// TODO Auto-generated method stub
		Optional<RepairPerson> optRepairPerson = repairPersonRepo.findById(repairPersonId);
		if(optRepairPerson.isEmpty()) {
			//throws new Exception("Repairperson with " + id + " is not present");
//			return false;
		}
		repairPersonRepo.delete(optRepairPerson.get());
		return true;
	}

	

}
