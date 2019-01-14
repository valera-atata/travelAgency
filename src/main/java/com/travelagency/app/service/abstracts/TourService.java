package com.travelagency.app.service.abstracts;

import java.util.List;

import com.travelagency.app.entity.TourEntity;

public interface TourService {

	void add(TourEntity tour);

	List<TourEntity> getAll();
	
	List<Object[]> getSumOfContracts();
}
