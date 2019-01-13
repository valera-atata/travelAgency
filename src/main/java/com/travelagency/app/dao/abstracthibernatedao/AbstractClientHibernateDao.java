package com.travelagency.app.dao.abstracthibernatedao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.travelagency.app.dao.BaseDao;
import com.travelagency.app.entity.ClientEntity;

@Transactional
public abstract class AbstractClientHibernateDao {

	@Autowired
	protected SessionFactory sessionFactory;
	
//	@Override
	public void add(ClientEntity client) {
		sessionFactory.getCurrentSession().save(client);
	}
	
//	@Override
	public List<ClientEntity> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from ClientEntity").list();
	}

	public abstract List<ClientEntity> getAllByAgent(String login);
	
}
