package com.travelagency.app.dao.abstractdao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.travelagency.app.dao.BaseDao;
import com.travelagency.app.entity.ClientEntity;
import com.travelagency.app.utils.SessionUtil;

public abstract class AbstractClientHibernateDao implements BaseDao<ClientEntity>{
	
	public ClientEntity add(ClientEntity client) {
		Session session = SessionUtil.openTransactionSession();
		session.save(client);
		SessionUtil.closeTransactionSession(session);
		return client;
	}

	public List<ClientEntity> getAll() {
		Session session = SessionUtil.openTransactionSession();
		String sql = "SELECT * FROM clients";
		Query query = session.createSQLQuery(sql).addEntity(ClientEntity.class);
		List<ClientEntity> clientList = query.list();
		SessionUtil.closeTransactionSession(session);
		return clientList;
	}

	public ClientEntity getById(Long id) {
		Session session = SessionUtil.openTransactionSession();
		String sql = "SELECT * FROM clients WHERE client_id = :id";
		Query query = session.createSQLQuery(sql).addEntity(ClientEntity.class);
		query.setParameter("id", id);
		ClientEntity client = (ClientEntity) query.uniqueResult();
		SessionUtil.closeTransactionSession(session);
		return client;
	}

	public ClientEntity update(ClientEntity client) {
		Session session = SessionUtil.openTransactionSession();
		session.update(client);
		SessionUtil.closeTransactionSession(session);
		return client;
	}

	public void remove(ClientEntity client) {
		Session session = SessionUtil.openTransactionSession();
		session.delete(client);
		SessionUtil.closeTransactionSession(session);
	}
	
	protected abstract ClientEntity getFirstClient(); 

}
