package com.biblio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblio.dao.IDao;
import com.biblio.entity.Editeur;

@Service
public class ServiceEditeurImpl implements IService<Editeur> {
	
	@Autowired
	private IDao<Editeur> daoEdteur;
	
	@Override
	public Editeur rechercherParId(int id) {
		return daoEdteur.selectById(id);
	}

	@Override
	public List<Editeur> findAll() {
		return daoEdteur.selectAll();
	}

	@Override
	public List<Editeur> chercherParString(String str) {
		return daoEdteur.searchLike(str);
	}

	@Override
	public Editeur ajouter(Editeur editeur) {
		return daoEdteur.insert(editeur);
	}

	@Override
	public void maj(Editeur editeur) {
		daoEdteur.update(editeur);
	}

	@Override
	public void supprimer(int id) {
	    daoEdteur.delete(id);
	}

}
