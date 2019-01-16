package com.travelagency.app.service.abstracts;

import java.util.List;

import com.travelagency.app.entity.ClientEntity;

public interface ClientService {

	void add(ClientEntity client);
	
	void update(ClientEntity client);
	
	void delete(ClientEntity client);
	
	List<ClientEntity> getAllByAgent(String login);
	
	List<ClientEntity> getAll();
	
	ClientEntity getById(Long id);
	
}
