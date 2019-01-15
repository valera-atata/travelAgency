package com.travelagency.app.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelagency.app.dao.abstracthibernatedao.AbstractAgentHibernateDao;
import com.travelagency.app.dao.abstracthibernatedao.AbstractClientHibernateDao;
import com.travelagency.app.entity.ClientEntity;
import com.travelagency.app.service.abstracts.ClientService;

@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	private AbstractAgentHibernateDao agentDao;
	
	@Autowired 
	AbstractClientHibernateDao clientDao;
	
	@Override
	public void add(ClientEntity client) {
		clientDao.add(client);
	}
	
	@Override
	public List<ClientEntity> getAllByAgent(String login) {
		return clientDao.getAllByAgent(login);
	}

	@Override
	public List<ClientEntity> getAll() {
		return clientDao.getAll();
	}

	@Override
	public ClientEntity getById(Long id) {
		return clientDao.getById(id);
	}
	
}
