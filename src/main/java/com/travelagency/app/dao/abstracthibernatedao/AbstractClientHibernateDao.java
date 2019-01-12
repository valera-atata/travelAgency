package com.travelagency.app.dao.abstracthibernatedao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.travelagency.app.entity.AgentEntity;
import com.travelagency.app.entity.ClientEntity;

public abstract class AbstractClientHibernateDao {

	@Autowired
	protected SessionFactory sessionFactory;
	
	public void add(ClientEntity client) {
		sessionFactory.getCurrentSession().save(client);
	}
	
	
	public abstract List<ClientEntity> getAllByAgent(AgentEntity agent);
	
}
