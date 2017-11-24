package com.sravs.common.db;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public abstract class BaseJpaDao<ID, E> implements Dao<ID, E> {

    protected Class<E> entityClass;

    protected EntityManager entityManager;

    public BaseJpaDao(Class<E> persistentClass) {
        entityClass = persistentClass;
    }

    public Class<E> getEntityClass() {
        return entityClass;
    }

    @Override
    public E create(E entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public void delete(E entity) {
        entityManager.remove(entity);
    }

    @Override
    public void delete(List<E> entities) {
        entities.forEach(entityManager::remove);
    }

    @Override
    public void deleteById(ID id) {
        entityManager.remove(entityManager.getReference(entityClass, id));
    }

    @Override
    public E find(ID id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public E update(E entity) {
        entityManager.merge(entity);
        return entity;
    }

    abstract public void setEntityManager(EntityManager entityManager);

    @Override
    public E refresh(E entity) {
        entityManager.refresh(entity);
        return entity;
    }

    public List findAll() {
        String sql = "From " + entityClass.getSimpleName();
        Query query = entityManager.createQuery(sql);
        return query.getResultList();
    }
}