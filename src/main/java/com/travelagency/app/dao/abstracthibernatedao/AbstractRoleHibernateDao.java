package com.travelagency.app.dao.abstracthibernatedao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.travelagency.app.dao.BaseDao;
import com.travelagency.app.entity.RoleEntity;

@Transactional
public abstract class AbstractRoleHibernateDao {
	
	@Autowired
	protected SessionFactory sessionFactory;
	
//	@Override
	public void add(RoleEntity agent) {
		sessionFactory.getCurrentSession().save(agent);
	}
	
//	@Override
	public List<RoleEntity> getAll(){
		return sessionFactory.getCurrentSession().createQuery("from RoleEntity").list();
	}
	
	public abstract RoleEntity getById(long id);
	
}
