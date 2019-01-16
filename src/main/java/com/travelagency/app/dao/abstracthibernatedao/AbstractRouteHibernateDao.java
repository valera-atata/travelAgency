package com.travelagency.app.dao.abstracthibernatedao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.travelagency.app.dao.BaseDao;
import com.travelagency.app.entity.ContractEntity;
import com.travelagency.app.entity.RouteEntity;

@Transactional
public abstract class AbstractRouteHibernateDao {

	@Autowired
	protected SessionFactory sessionFactory;
	
//	@Override
	public void add(RouteEntity route) {
		sessionFactory.getCurrentSession().save(route);
	}

//	@Override
	public void update(RouteEntity route) {
		sessionFactory.getCurrentSession().update(route);
	}
	
//	@Override
	public void delete(RouteEntity route) {
		sessionFactory.getCurrentSession().delete(route);
	}
	
//	@Override
	public List<RouteEntity> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from RouteEntity").list();
	}
	
//	@Override
	public RouteEntity getById(Long id) {
		return (RouteEntity) sessionFactory.getCurrentSession().createQuery("from RouteEntity where id=?").setParameter(0, id).uniqueResult();
	}
	
}
