package com.travelagency.app.dao.abstractdao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.travelagency.app.dao.BaseDao;
import com.travelagency.app.entity.TourEntity;
import com.travelagency.app.utils.SessionUtil;

public abstract class AbstractTourHibernateDao implements BaseDao<TourEntity>{
	
	public TourEntity add(TourEntity tour) {
		Session session = SessionUtil.openTransactionSession();
		session.save(tour);
		SessionUtil.closeTransactionSession(session);
		return tour;
	}

	public List<TourEntity> getAll() {
		Session session = SessionUtil.openTransactionSession();
		String sql = "SELECT * FROM tours";
		Query query = session.createSQLQuery(sql).addEntity(TourEntity.class);
		List<TourEntity> tourList = query.list();
		SessionUtil.closeTransactionSession(session);
		return tourList;
	}

	public TourEntity getById(Long id) {
		Session session = SessionUtil.openTransactionSession();
		String sql = "SELECT * FROM tours WHERE tour_id = :id";
		Query query = session.createSQLQuery(sql).addEntity(TourEntity.class);
		query.setParameter("id", id);
		TourEntity tour = (TourEntity) query.uniqueResult();
		SessionUtil.closeTransactionSession(session);
		return tour;
	}

	public TourEntity update(TourEntity tour) {
		Session session = SessionUtil.openTransactionSession();
		session.update(tour);
		SessionUtil.closeTransactionSession(session);
		return tour;
	}

	public void remove(TourEntity tour) {
		Session session = SessionUtil.openTransactionSession();
		session.delete(tour);
		SessionUtil.closeTransactionSession(session);
	}
	
	protected abstract TourEntity getFirstRole();

}
