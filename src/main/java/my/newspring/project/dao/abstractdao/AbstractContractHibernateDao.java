package my.newspring.project.dao.abstractdao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import my.newspring.project.dao.BaseDao;
import my.newspring.project.dao.entity.ContractEntity;
import my.newspring.project.utils.SessionUtil;

public abstract class AbstractContractHibernateDao implements BaseDao<ContractEntity> {

	public ContractEntity add(ContractEntity contract) {
		Session session = SessionUtil.openTransactionSession();
		session.save(contract);
		SessionUtil.closeTransactionSession(session);
		return contract;
	}

	public List<ContractEntity> getAll() {
		Session session = SessionUtil.openTransactionSession();
		String sql = "SELECT * FROM contracts";
		Query query = session.createSQLQuery(sql).addEntity(ContractEntity.class);
		List<ContractEntity> contractList = query.list();
		SessionUtil.closeTransactionSession(session);
		return contractList;
	}

	public ContractEntity getById(Long id) {
		Session session = SessionUtil.openTransactionSession();
		String sql = "SELECT * FROM contracts WHERE contract_id = :id";
		Query query = session.createSQLQuery(sql).addEntity(ContractEntity.class);
		query.setParameter("id", id);
		ContractEntity contract = (ContractEntity) query.uniqueResult();
		SessionUtil.closeTransactionSession(session);
		return contract;
	}

	public ContractEntity update(ContractEntity contract) {
		Session session = SessionUtil.openTransactionSession();
		session.update(contract);
		SessionUtil.closeTransactionSession(session);
		return contract;
	}

	public void remove(ContractEntity contract) {
		Session session = SessionUtil.openTransactionSession();
		session.delete(contract);
		SessionUtil.closeTransactionSession(session);
	}
	
	protected abstract ContractEntity getFirstContract(); 
	
}
