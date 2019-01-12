package com.travelagency.app.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelagency.app.dao.abstracthibernatedao.AbstractTourHibernateDao;
import com.travelagency.app.entity.TourEntity;
import com.travelagency.app.service.abstracts.TourService;

@Service
public class TourServiceImpl implements TourService {

	@Autowired
	private AbstractTourHibernateDao tourDao;
	
	@Override
	public void add(TourEntity tour) {
		tourDao.add(tour);
	}
	
}
