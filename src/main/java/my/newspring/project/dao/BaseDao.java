package my.newspring.project.dao;

import java.util.List;

public interface BaseDao<T> {
	
	T add(T t);

	List<T> getAll();

	T getById(Long id);

	T update(T t);

	void remove(T t);
}
