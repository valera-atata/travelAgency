package com.travelagency.app.dao.hibernatedao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;

import com.travelagency.app.dao.abstracthibernatedao.AbstractAgentHibernateDao;
import com.travelagency.app.entity.AgentEntity;

@Transactional
public class AgentHibernateDao extends AbstractAgentHibernateDao {

	@Override
    public AgentEntity getByLogin(String login) {
    	String sql = "SELECT * FROM agents WHERE login = :login";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(AgentEntity.class);
		query.setParameter("login", login);
    	AgentEntity agentEntity = (AgentEntity) query.uniqueResult();
    	return agentEntity;
    }
	
	@Override
	public List<Object[]> getStatistics(){
		String sql = "select C.agent_id, "
				+ "(select count(D.client_id) "
				+ "from (SELECT DISTINCT contracts.client_id, contracts.agent_id FROM contracts) AS D "
				+ "WHERE C.agent_id = D.agent_id), "
				+ "count(C.agent_id), "
				+ "sum((select T.cost from tours as T where T.tour_id = C.tour_id)) "
				+ "from contracts as C group by C.agent_id";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		return query.list();
	}
}
