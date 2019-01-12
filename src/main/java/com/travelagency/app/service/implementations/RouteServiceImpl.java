package com.travelagency.app.service.implementations;

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
	
}
