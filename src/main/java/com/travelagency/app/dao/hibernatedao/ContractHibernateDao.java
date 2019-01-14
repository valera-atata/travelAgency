package com.travelagency.app.dao.hibernatedao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;

import com.travelagency.app.dao.abstracthibernatedao.AbstractContractHibernateDao;
import com.travelagency.app.entity.ContractEntity;

@Transactional
public class ContractHibernateDao extends AbstractContractHibernateDao {

	@Override
	public List<ContractEntity> getAllByAgent(String login) {
		String sql = "select contracts.contract_id, contracts.date, contracts.agent_id, "
				+ "contracts.client_id, contracts.tour_id from contracts, agents "
				+ "where agents.login = :login "
				+ "and contracts.agent_id = agents.agent_id";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(ContractEntity.class);
		query.setParameter("login", login);
		return query.list();
	}
	
}
