package com.travelagency.app.dao;

import java.util.List;

public interface BaseDao<T> {
	
	void add(T t);
	
	List<T> getAll();
}
