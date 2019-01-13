package com.travelagency.app.dao.hibernatedao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;

import com.travelagency.app.dao.abstracthibernatedao.AbstractClientHibernateDao;
import com.travelagency.app.entity.ClientEntity;

@Transactional
public class ClientHibernateDao extends AbstractClientHibernateDao {

	public List<ClientEntity> getAllByAgent(String login){
		String sql = "select * from clients where clients.client_id in "
				+ "(select contracts.client_id from contracts where contracts.agent_id = "
				+ "(select agents.agent_id from agents where agents.login = :login))";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(ClientEntity.class);
		query.setParameter("login", login);
		return query.list();
	}
	
}
