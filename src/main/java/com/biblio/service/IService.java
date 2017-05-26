package com.biblio.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.biblio.entity.Metier;


public interface IService<T extends Metier> {
	
	
	public T rechercherParId(int id);
	
	public List<T> findAll();
	
	public List<T> chercherParString(String str);
	
	
    public T ajouter(T objet);
    
    public void maj(T objet);
    
    public  void  supprimer(int id);
	
	

}
