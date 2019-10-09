package br.com.phellipe.persistence;

import java.util.List;

public interface IPersitence<T> {
	
	public void create(T obj) throws Exception;
	
	public T findById(Long id) throws Exception;
	
	public List<T> findAll() throws Exception;
	
	public void update(T obj) throws Exception;
	
	public void delete(Long id) throws Exception;
	
}
