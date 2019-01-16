package com.travelagency.app.service.abstracts;

import java.util.List;

import com.travelagency.app.entity.ContractEntity;

public interface ContractService {

	void add(ContractEntity contract);

	void update(ContractEntity contract);
	
	void delete(ContractEntity contract);

	List<ContractEntity> getAllByAgent(String login);
	
	List<ContractEntity> getAll();
	
	ContractEntity getById(Long id);
}
