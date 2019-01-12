package com.travelagency.app.dao.hibernatedao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;

import com.travelagency.app.dao.abstracthibernatedao.AbstractClientHibernateDao;
import com.travelagency.app.entity.AgentEntity;
import com.travelagency.app.entity.ClientEntity;

@Transactional
public class ClientHibernateDao extends AbstractClientHibernateDao {

	public List<ClientEntity> getAllByAgent(AgentEntity agent){
//		String sql = "SELECT * FROM clients WHERE agent_id = :id";
//		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(ClientEntity.class);
//		query.setParameter("login", agentId);
//    	AgentEntity agentEntity = (AgentEntity) query.uniqueResult();
//    	System.out.println("AGENT BY LOGIN:  " + agentEntity);
//    	return agentEntity;
		return null;
	}
	
}
