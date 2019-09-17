package dao;

import javax.persistence.EntityManager;
import util.UtilJPA;

public class GenericDAO<T, I> {

	private Class<T> persistedClass;

	protected GenericDAO() {
	}

	protected GenericDAO(Class<T> persistedClass) {
		this();
		this.persistedClass = persistedClass;
	}

	public T add(T entity) {
		EntityManager em = UtilJPA.getEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.flush();
		em.getTransaction().commit();

		return entity;
	}

	public T update(T entity) {
		EntityManager em = UtilJPA.getEntityManager();
		em.getTransaction().begin();
		em.merge(entity);
		em.flush();
		em.getTransaction().commit();

		return entity;
	}

	public T find(I id) {
		EntityManager em = UtilJPA.getEntityManager();
		return em.find(persistedClass, id);
	}

	public void remove(I id) {
		T entity = find(id);

		EntityManager em = UtilJPA.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.contains(entity) ? entity : em.merge(entity));
		em.flush();
		em.getTransaction().commit();
	}

}
