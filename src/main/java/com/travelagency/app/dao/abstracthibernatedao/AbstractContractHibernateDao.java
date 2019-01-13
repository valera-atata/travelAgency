package com.travelagency.app.dao.abstracthibernatedao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.travelagency.app.dao.BaseDao;
import com.travelagency.app.entity.ContractEntity;

@Transactional
public abstract class AbstractContractHibernateDao {

	@Autowired
	protected SessionFactory sessionFactory;
	
//	@Override
	public void add(ContractEntity contract) {
		sessionFactory.getCurrentSession().save(contract);
	}
	
//	@Override
	public List<ContractEntity> getAll(){
		return sessionFactory.getCurrentSession().createQuery("from ContractEntity").list();
	}
	
	public abstract List<ContractEntity> getAllByAgent(String login);
	
	
}
