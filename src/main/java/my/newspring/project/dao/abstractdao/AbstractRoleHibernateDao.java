package my.newspring.project.dao.abstractdao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import my.newspring.project.dao.BaseDao;
import my.newspring.project.dao.entity.RoleEntity;
import my.newspring.project.utils.SessionUtil;

public abstract class AbstractRoleHibernateDao implements BaseDao<RoleEntity>{

	public RoleEntity add(RoleEntity role) {
		Session session = SessionUtil.openTransactionSession();
		session.save(role);
		SessionUtil.closeTransactionSession(session);
		return role;
	}

	public List<RoleEntity> getAll() {
		Session session = SessionUtil.openTransactionSession();
		String sql = "SELECT * FROM roles";
		Query query = session.createSQLQuery(sql).addEntity(RoleEntity.class);
		List<RoleEntity> roleList = query.list();
		SessionUtil.closeTransactionSession(session);
		return roleList;
	}

	public RoleEntity getById(Long id) {
		Session session = SessionUtil.openTransactionSession();
		String sql = "SELECT * FROM roles WHERE role_id = :id";
		Query query = session.createSQLQuery(sql).addEntity(RoleEntity.class);
		query.setParameter("id", id);
		RoleEntity role = (RoleEntity) query.uniqueResult();
		SessionUtil.closeTransactionSession(session);
		return role;
	}

	public RoleEntity update(RoleEntity role) {
		Session session = SessionUtil.openTransactionSession();
		session.update(role);
		SessionUtil.closeTransactionSession(session);
		return role;
	}

	public void remove(RoleEntity role) {
		Session session = SessionUtil.openTransactionSession();
		session.delete(role);
		SessionUtil.closeTransactionSession(session);
	}
	
	protected abstract RoleEntity getFirstRole();
	
}
