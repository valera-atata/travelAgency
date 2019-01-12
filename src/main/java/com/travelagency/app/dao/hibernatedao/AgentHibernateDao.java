package com.travelagency.app.dao.hibernatedao;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;

import com.travelagency.app.dao.abstracthibernatedao.AbstractAgentHibernateDao;
import com.travelagency.app.entity.AgentEntity;

@Transactional
public class AgentHibernateDao extends AbstractAgentHibernateDao {

    public AgentEntity getByLogin(String login) {
    	String sql = "SELECT * FROM agents WHERE login = :login";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(AgentEntity.class);
		query.setParameter("login", login);
    	AgentEntity agentEntity = (AgentEntity) query.uniqueResult();
    	System.out.println("AGENT BY LOGIN:  " + agentEntity);
    	return agentEntity;
    }
	
}
