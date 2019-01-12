package com.travelagency.app.dao.abstracthibernatedao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.travelagency.app.entity.RouteEntity;

public abstract class AbstractRouteHibernateDao {

	@Autowired
	protected SessionFactory sessionFactory;
	
	public void add(RouteEntity route) {
		sessionFactory.getCurrentSession().save(route);
	}
	
}
