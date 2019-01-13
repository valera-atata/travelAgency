package com.travelagency.app.dao.abstracthibernatedao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.travelagency.app.dao.BaseDao;
import com.travelagency.app.entity.AgentEntity;

@Transactional
public abstract class AbstractAgentHibernateDao {
	
	@Autowired
	protected SessionFactory sessionFactory;
	
//	@Override
	public void add(AgentEntity agentEntity) {
		sessionFactory.getCurrentSession().save(agentEntity);
	}
    
//	@Override
    public List<AgentEntity> getAll(){
    	return sessionFactory.getCurrentSession().createQuery("from AgentEntity").list();
    }
    
    public abstract AgentEntity getByLogin(String login);
}
