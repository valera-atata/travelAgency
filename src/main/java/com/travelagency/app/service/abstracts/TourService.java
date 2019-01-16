package com.travelagency.app.service.abstracts;

import java.util.List;

import com.travelagency.app.entity.TourEntity;

public interface TourService {

	void add(TourEntity tour);
	
	void update(TourEntity tour);
	
	void delete(TourEntity tour);

	List<TourEntity> getAll();
	
	List<Object[]> getSumOfContracts();
	
	TourEntity getById(Long id);
}
