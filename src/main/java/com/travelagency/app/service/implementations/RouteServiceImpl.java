package com.travelagency.app.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelagency.app.dao.abstracthibernatedao.AbstractRouteHibernateDao;
import com.travelagency.app.entity.RouteEntity;
import com.travelagency.app.service.abstracts.RouteService;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private AbstractRouteHibernateDao routeDao;
	
	@Override
	public void add(RouteEntity route) {
		routeDao.add(route);
	}
	
	@Override
	public List<RouteEntity> getAll(){
		return routeDao.getAll();
	}
	
	@Override
	public RouteEntity getById(Long id) {
		return routeDao.getById(id);
	}
}
