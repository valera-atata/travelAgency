package com.travelagency.app.dao.abstractdao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.travelagency.app.dao.BaseDao;
import com.travelagency.app.entity.RouteEntity;
import com.travelagency.app.utils.SessionUtil;

public abstract class AbstractRouteHibernateDao implements BaseDao<RouteEntity> {
	
	public RouteEntity add(RouteEntity route) {
		Session session = SessionUtil.openTransactionSession();
		session.save(route);
		SessionUtil.closeTransactionSession(session);
		return route;
	}

	public List<RouteEntity> getAll() {
		Session session = SessionUtil.openTransactionSession();
		String sql = "SELECT * FROM routes";
		Query query = session.createSQLQuery(sql).addEntity(RouteEntity.class);
		List<RouteEntity> routeList = query.list();
		SessionUtil.closeTransactionSession(session);
		return routeList;
	}

	public RouteEntity getById(Long id) {
		Session session = SessionUtil.openTransactionSession();
		String sql = "SELECT * FROM routes WHERE route_id = :id";
		Query query = session.createSQLQuery(sql).addEntity(RouteEntity.class);
		query.setParameter("id", id);
		RouteEntity route = (RouteEntity) query.uniqueResult();
		SessionUtil.closeTransactionSession(session);
		return route;
	}

	public RouteEntity update(RouteEntity route) {
		Session session = SessionUtil.openTransactionSession();
		session.update(route);
		SessionUtil.closeTransactionSession(session);
		return route;
	}

	public void remove(RouteEntity route) {
		Session session = SessionUtil.openTransactionSession();
		session.delete(route);
		SessionUtil.closeTransactionSession(session);
	}
	
	protected abstract RouteEntity getFirstTour(); 
	
//	public RouteEntity add(RouteEntity route) {
//		SessionUtil.openTransactionSession();
//		Session session = SessionUtil.getSession();
//		session.save(route);
//		SessionUtil.closeTransactionSession(session);
//		return route;
//	}
//
//	public List<RouteEntity> getAll() {
//		SessionUtil.openTransactionSession();
//		String sql = "SELECT * FROM routes";
//		Session session = SessionUtil.getSession();
//		Query query = session.createSQLQuery(sql).addEntity(RouteEntity.class);
//		List<RouteEntity> routeList = query.list();
//		SessionUtil.closeTransactionSession(session);
//		return routeList;
//	}
//
//	public RouteEntity getById(Long id) {
//		SessionUtil.openTransactionSession();
//		String sql = "SELECT * FROM routes WHERE id = :id";
//		Session session = SessionUtil.getSession();
//		Query query = session.createSQLQuery(sql).addEntity(RouteEntity.class);
//		query.setParameter("id", id);
//		RouteEntity route = (RouteEntity) query.uniqueResult();
//		SessionUtil.closeTransactionSession(session);
//		return route;
//	}
//
//	public RouteEntity update(RouteEntity route) {
//		SessionUtil.openTransactionSession();
//		Session session = SessionUtil.getSession();
//		session.update(route);
//		SessionUtil.closeTransactionSession(session);
//		return route;
//	}
//
//	public void remove(RouteEntity route) {
//		SessionUtil.openTransactionSession();
//		Session session = SessionUtil.getSession();
//		session.delete(route);
//		SessionUtil.closeTransactionSession(session);
//	}
	

}
