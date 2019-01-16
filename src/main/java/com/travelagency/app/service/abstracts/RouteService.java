package com.travelagency.app.service.abstracts;

import java.util.List;

import com.travelagency.app.entity.RouteEntity;

public interface RouteService {

	void add(RouteEntity route);

	List<RouteEntity> getAll();
	
	RouteEntity getById(Long id);
}
