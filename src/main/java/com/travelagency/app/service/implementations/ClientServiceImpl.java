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
		agentDao.getByLogin(login).getAgentId();
		
		return null;
	}

	@Override
	public List<ClientEntity> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
