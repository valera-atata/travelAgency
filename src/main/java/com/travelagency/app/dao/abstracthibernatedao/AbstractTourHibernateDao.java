package com.travelagency.app.dao.abstracthibernatedao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.travelagency.app.dao.BaseDao;
import com.travelagency.app.entity.RouteEntity;
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
	public void update(TourEntity tour) {
		sessionFactory.getCurrentSession().update(tour);
	}
	
//	@Override
	public void delete(TourEntity tour) {
		sessionFactory.getCurrentSession().delete(tour);
	}

//	@Override
	public List<TourEntity> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from TourEntity").list();
	}
	
//	@Override
	public TourEntity getById(Long id) {
		return (TourEntity) sessionFactory.getCurrentSession().createQuery("from TourEntity where id=?").setParameter(0, id).uniqueResult();
	}
	
	public abstract List<Object[]> getSumOfContracts();
	
}
