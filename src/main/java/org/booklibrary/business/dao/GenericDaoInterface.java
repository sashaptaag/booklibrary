package org.booklibrary.business.dao;

import java.util.List;

public interface GenericDaoInterface<T> {
    /**
     * @param entity
     */
    void persist(T entity);

    /**
     * @param entity
     */
    void update(T entity);

    /**
     * @param id
     * @return
     */
    T findById(Long id);

    /**
     * @param entity
     */
    void delete(T entity);

    /**
     * @return
     */
    List<T> findAll();

    /**
     *
     */
    void deleteAll();
}
