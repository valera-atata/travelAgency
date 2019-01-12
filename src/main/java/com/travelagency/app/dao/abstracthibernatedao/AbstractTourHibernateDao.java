package com.travelagency.app.dao.abstracthibernatedao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.travelagency.app.entity.TourEntity;

public abstract class AbstractTourHibernateDao {

	@Autowired
	protected SessionFactory sessionFactory;
	
	public void add(TourEntity tour) {
		sessionFactory.getCurrentSession().save(tour);
	}
	
}
