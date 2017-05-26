package com.biblio.dao;

import java.util.List;

import com.biblio.entity.Metier;

public interface IDao<T extends Metier>{
	
	public T selectById(int id);
	public List<T> selectAll();
	
	public List<T> searchLike(String str);
	
	
	public T insert(T objet);
	
	public void update(T objet);
	
	public void delete(int id);

}
