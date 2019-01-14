package com.travelagency.app.dao.hibernatedao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;

import com.travelagency.app.dao.abstracthibernatedao.AbstractTourHibernateDao;
import com.travelagency.app.entity.ContractEntity;
import com.travelagency.app.entity.TourEntity;

@Transactional
public class TourHibernateDao extends AbstractTourHibernateDao {

	@Override
	public List<Object[]> getSumOfContracts() {
		String sql = "select tours.tour_id, tours.cost, tours.organizer, tours.date, tours.type, "
				+ "(select count(*) from contracts where contracts.tour_id = tours.tour_id) "
				+ "from tours group by tours.organizer, tours.date, tours.type, tours.tour_id;";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		return query.list();
	}
	
}
