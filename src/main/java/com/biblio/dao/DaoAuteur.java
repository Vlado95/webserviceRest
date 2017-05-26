package com.biblio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.biblio.entity.Auteur;



@Component // ou bien @repository
@Transactional // version spring
public class DaoAuteur implements IDao<Auteur> {

	@PersistenceContext(unitName = "myPersistenceUnit") // inection
														// +initialisation
														// connexion base
	private EntityManager entityManager; // JPA

	@Override
	public Auteur selectById(int id) {
		return entityManager.find(Auteur.class, id);
	}

	@Override
	public List<Auteur> selectAll() {
		/*
		 * return entityManager.createQuery("SELECT a FROM Auteur a",
		 * Auteur.class).getResultList();
		 */
		return entityManager.createNamedQuery("auteur.all", Auteur.class).getResultList();
	}

	@Override
	public List<Auteur> searchLike(String str) {
		return entityManager.createNamedQuery("auteur.search", Auteur.class).setParameter(1, "%" + str + "%")
				.getResultList();
	}

	@Override
	public Auteur insert(Auteur a) {
		entityManager.persist(a);
		// la clef primaire auto incr�ment� par mysql
		// remonte dans l'objet java lors du .persist()
		// grace � @GeneratedValue() sur l'id de l'Auteur
		return a;
	}

	@Override
	public void update(Auteur a) {
		// entityManager.getTransaction().begin() effectu� via @Transactional
		entityManager.merge(a);
		// entityManager.getTransaction().commit() effectu� via @Transactional
	}

	@Override
	public void delete(int id) {
		Auteur a = entityManager.find(Auteur.class, id);
		entityManager.remove(a);

	}

}
