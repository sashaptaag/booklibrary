package org.booklibrary.business.services;

import java.util.List;

import org.booklibrary.core.Author;

public interface AuthorService {
    /**
     *
     * @param author
     * @return
     */
    Author save(Author author);

    /**
     *
     * @param author
     */
    void delete(Author author);

    /**
     *
     * @return
     */
    List<Author> findAll();

    /**
     *
     * @param id
     * @return
     */
    Author findById(Long id);
}
