package com.biblio.rest;

import java.util.List;

import javax.ws.rs.core.Response;

import com.biblio.entity.Metier;

public interface ServiceRest<T extends Metier> {
	
	public T rechercher(int id);
	
	public List<T> getAll();

	public List<T> getAll(String str);

	public Response ajouter(T objet);

	public Response supprimer(int id);
	
	public Response maj(int id, T objet);
}
