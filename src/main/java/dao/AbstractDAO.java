package dao;

import javax.persistence.EntityManager;
import interfaces.IDAO;
import interfaces.IEntity;
import util.UtilJPA;

public class AbstractDAO implements IDAO {

	public void add(IEntity pEntidade) {
		add(pEntidade, UtilJPA.getEntityManager(), true);
	}

	public void add(IEntity pEntidade, EntityManager pEM, boolean pFecharEM) {
		pEM.getTransaction().begin();
		pEM.persist(pEntidade);
		pEM.getTransaction().commit();
		if (pFecharEM) {
			pEM.close();
		}
	}

	public IEntity listByPrimaryKey(Class pClasse, Object pPrimaryKey) {
		return listByPrimaryKey(pClasse, pPrimaryKey, UtilJPA.getEntityManager(), true);
	}

	public IEntity listByPrimaryKey(Class pClass, Object pPrimaryKey, EntityManager pEM, boolean pCloseEM) {
		IEntity entity = pEM.find(pClass, pPrimaryKey);
		if (pCloseEM)
			pEM.close();

		return entity;
	}

	public IEntity listByObject(IEntity pEntity) {
		return listByObject(pEntity, UtilJPA.getEntityManager(), true);
	}

	private IEntity listByObject(IEntity pEntity, EntityManager pEM, boolean pCloseEM) {
		IEntity entity = (IEntity) pEM.find(pEntity.getClass(), pEntity.getPrimaryKey());

		if (pCloseEM)
			pEM.close();

		return entity;
	}

	public void update(IEntity pEntity) {
		update(pEntity, UtilJPA.getEntityManager(), true);
	}

	private void update(IEntity pEntity, EntityManager pEM, boolean pCloseEM) {
		pEM.getTransaction().begin();
		pEM.merge(pEntity);
		pEM.getTransaction().commit();

		if (pCloseEM)
			pEM.close();
	}

	public void removeByPrimaryKey(IEntity pEntity, Object pPrimaryKey) {
		removeByPrimaryKey(pEntity, pPrimaryKey, UtilJPA.getEntityManager(), true);
	}

	private void removeByPrimaryKey(IEntity pEntity, Object pPrimaryKey, EntityManager pEM, boolean pCloseEM) {
		pEM.getTransaction().begin();

		IEntity entity = (IEntity) pEM.find(pEntity.getClass(), pPrimaryKey);

		pEM.remove(pEM.contains(entity) ? entity : pEM.merge(entity));

		pEM.getTransaction().commit();
	}

	public void removeByObject(IEntity pEntity) {
		removeByObject(pEntity, UtilJPA.getEntityManager(), true);
	}

	private void removeByObject(IEntity pEntity, EntityManager pEM, boolean pCloseEM) {
		pEM.getTransaction().begin();
		pEM.remove(pEM.contains(pEntity) ? pEntity : pEM.merge(pEntity));
		pEM.getTransaction().commit();

		if (pCloseEM)
			pEM.close();
	}
	

}
