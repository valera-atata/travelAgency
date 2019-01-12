package com.travelagency.app.dao.abstracthibernatedao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.travelagency.app.entity.ContractEntity;

public abstract class AbstractContractHibernateDao {

	@Autowired
	protected SessionFactory sessionFactory;
	
	public void add(ContractEntity contract) {
		sessionFactory.getCurrentSession().save(contract);
	}
	
}
