package com.travelagency.app.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelagency.app.dao.abstracthibernatedao.AbstractTourHibernateDao;
import com.travelagency.app.entity.ContractEntity;
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
	
	@Override
	public void update(TourEntity tour) {
		tourDao.update(tour);
	}

	@Override
	public void delete(TourEntity tour) {
		tourDao.delete(tour);
	}

	@Override
	public List<TourEntity> getAll(){
		return tourDao.getAll();
	}
	
	@Override
	public List<Object[]> getSumOfContracts() {
		return tourDao.getSumOfContracts();
	}
	
	@Override
	public TourEntity getById(Long id) {
		return tourDao.getById(id);
	}
	
}
