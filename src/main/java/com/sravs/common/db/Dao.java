package com.sravs.common.db;

import java.util.List;

public interface Dao<ID, E> {

    Class<E> getEntityClass();

    E create(E entity);

    void delete(E entity);

    void delete(List<E> entities);

    void deleteById(ID id);

    E find(ID id);

    E update(E entity);

    E refresh(E entity);

    List findAll();
}
