package com.travelagency.app.dao.abstracthibernatedao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.travelagency.app.dao.BaseDao;
import com.travelagency.app.entity.RoleEntity;

@Transactional
public abstract class AbstractRoleHibernateDao implements BaseDao<RoleEntity> {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void save(RoleEntity agent) {
		sessionFactory.getCurrentSession().save(agent);
	}
	
	public RoleEntity getById(long id) {
		return (RoleEntity) sessionFactory.getCurrentSession().createQuery("from RoleEntity where id=?").setParameter(0, id).uniqueResult();
	}
}
