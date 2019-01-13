package com.travelagency.app.dao.abstracthibernatedao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.travelagency.app.dao.BaseDao;
import com.travelagency.app.entity.TourEntity;

@Transactional
public abstract class AbstractTourHibernateDao {

	@Autowired
	protected SessionFactory sessionFactory;
	
//	@Override
	public void add(TourEntity tour) {
		sessionFactory.getCurrentSession().save(tour);
	}

//	@Override
	public List<TourEntity> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from TourEntity").list();
	}
	
}
