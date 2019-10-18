package br.com.phellipe.dao;

import java.util.List;

public interface IDao<T> {
	
	public void create(T obj) throws Exception;
	
	public T findById(Long id) throws Exception;
	
	public List<T> findAll() throws Exception;
	
	public void update(T obj) throws Exception;
	
	public void delete(Long id) throws Exception;
	
}
