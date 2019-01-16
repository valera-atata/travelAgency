package com.travelagency.app.dao.abstracthibernatedao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.travelagency.app.dao.BaseDao;
import com.travelagency.app.entity.AgentEntity;
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
	public void update(ClientEntity client) {
		sessionFactory.getCurrentSession().update(client);
	}
	
//	@Override
	public void delete(ClientEntity client) {
		sessionFactory.getCurrentSession().delete(client);
	}
	
//	@Override
	public List<ClientEntity> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from ClientEntity").list();
	}

//	@Override
	public ClientEntity getById(Long id) {
		return (ClientEntity) sessionFactory.getCurrentSession().createQuery("from ClientEntity where id=?").setParameter(0, id).uniqueResult();
	}
	
	public abstract List<ClientEntity> getAllByAgent(String login);
	
}
