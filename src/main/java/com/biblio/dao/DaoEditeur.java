package com.biblio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.biblio.entity.Editeur;

@Component // ou bien @repository
@Transactional // version spring
public class DaoEditeur implements IDao<Editeur> {

	@PersistenceContext(unitName = "myPersistenceUnit") // injection initialisation  connexion base
	
	private EntityManager entityManager; // JPA
	
	@Override
	public Editeur selectById(int id) {
		return entityManager.find(Editeur.class, 1);
	}

	@Override
	public List<Editeur> selectAll() {
		return entityManager.createNamedQuery("editeur.all", Editeur.class).getResultList();
	}

	@Override
	public List<Editeur> searchLike(String str) {
		return entityManager.createNamedQuery("editeur.search", Editeur.class).setParameter(1, "%" + str + "%")
				.getResultList();
	}

	@Override
	public Editeur insert(Editeur editeur) {
		entityManager.persist(editeur);
		return editeur;
	}

	@Override
	public void update(Editeur editeur) {
		entityManager.merge(editeur);
		
	}

	@Override
	public void delete(int id) {
		Editeur editeur = entityManager.find(Editeur.class, id);
		entityManager.remove(editeur);
		
	}

}
