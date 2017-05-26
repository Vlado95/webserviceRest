package com.biblio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.biblio.entity.Livre;

@Component // ou bien @repository
@Transactional // version spring
public class DaoLivre implements IDao<Livre> {

	@PersistenceContext(unitName = "myPersistenceUnit") // injection
														// initialisation
														// connexion base

	private EntityManager entityManager; // JPA

	@Override
	public Livre selectById(int id) {
		return entityManager.find(Livre.class, id);
	}

	@Override
	public List<Livre> selectAll() {
		return entityManager.createNamedQuery("livre.all", Livre.class).getResultList();
	}

	@Override
	public List<Livre> searchLike(String str) {
		return entityManager.createNamedQuery("livre.search", Livre.class).setParameter(1, "%" + str + "%")
				.getResultList();
	}

	@Override
	public Livre insert(Livre livre) {
		entityManager.persist(livre);
		return livre;
	}

	@Override
	public void update(Livre livre) {
		entityManager.merge(livre);

	}

	@Override
	public void delete(int id) {
		Livre livre = entityManager.find(Livre.class, id);
		entityManager.remove(livre);

	}

}
