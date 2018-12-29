package my.newspring.project.dao.abstractdao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import my.newspring.project.dao.BaseDao;
import my.newspring.project.dao.entity.AgentEntity;
import my.newspring.project.utils.SessionUtil;

public abstract class AbstractAgentHibernateDao implements BaseDao<AgentEntity> {

	public AgentEntity add(AgentEntity agent) {
		Session session = SessionUtil.openTransactionSession();
		session.save(agent);
		SessionUtil.closeTransactionSession(session);
		return agent;
	}

	public List<AgentEntity> getAll() {
		Session session = SessionUtil.openTransactionSession();
		String sql = "SELECT * FROM agents";
		Query query = session.createSQLQuery(sql).addEntity(AgentEntity.class);
		List<AgentEntity> agentList = query.list();
		SessionUtil.closeTransactionSession(session);
		return agentList;
	}

	public AgentEntity getById(Long id) {
		Session session = SessionUtil.openTransactionSession();
		String sql = "SELECT * FROM agents WHERE agent_id = :id";
		Query query = session.createSQLQuery(sql).addEntity(AgentEntity.class);
		query.setParameter("id", id);
		AgentEntity agent = (AgentEntity) query.uniqueResult();
		SessionUtil.closeTransactionSession(session);
		return agent;
	}

	public AgentEntity update(AgentEntity agent) {
		Session session = SessionUtil.openTransactionSession();
		session.update(agent);
		SessionUtil.closeTransactionSession(session);
		return agent;
	}

	public void remove(AgentEntity agent) {
		Session session = SessionUtil.openTransactionSession();
		session.delete(agent);
		SessionUtil.closeTransactionSession(session);
	}
	
	protected abstract AgentEntity getFirstRoute(); 
}
