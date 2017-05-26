package com.biblio.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblio.dao.IDao;
import com.biblio.entity.Auteur;

@Service
public class ServiceAuteurImpl implements IService<Auteur> {

	@Autowired
	private IDao<Auteur> daoAuteur;

	@Override
	public Auteur rechercherParId(int id) {
		return daoAuteur.selectById(id);
	}

	@Override
	public List<Auteur> findAll() {
		return daoAuteur.selectAll();
	}

	@Override
	public List<Auteur> chercherParString(String str) {
		return daoAuteur.searchLike(str);
	}

	@Override
	public Auteur ajouter(Auteur auteur) {
		return daoAuteur.insert(auteur);
	}

	@Override
	public void maj(Auteur auteur) {
		daoAuteur.update(auteur);

	}

	@Override
	public void supprimer(int idAuteur) {
		daoAuteur.delete(idAuteur);

	}

}
