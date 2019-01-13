package com.travelagency.app.dao.abstracthibernatedao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.travelagency.app.dao.BaseDao;
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
	public List<RouteEntity> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from RouteEntity").list();
	}
	
}
