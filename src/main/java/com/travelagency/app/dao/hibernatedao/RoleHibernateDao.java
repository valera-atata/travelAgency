package com.travelagency.app.dao.hibernatedao;

import javax.transaction.Transactional;

import com.travelagency.app.dao.abstracthibernatedao.AbstractRoleHibernateDao;
import com.travelagency.app.entity.RoleEntity;

@Transactional
public class RoleHibernateDao extends AbstractRoleHibernateDao { 
	
	@Override
	public RoleEntity getById(long id) {
		return (RoleEntity) sessionFactory.getCurrentSession().createQuery("from RoleEntity where id=?").setParameter(0, id).uniqueResult();
	}
	
}
