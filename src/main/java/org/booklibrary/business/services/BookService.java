package org.booklibrary.business.services;

import java.util.List;

import org.booklibrary.core.Book;
import org.booklibrary.core.Genre;

public interface BookService {
    /**
     * @param book
     * @return
     */
    void persist(Book book);

    /**
     * @param book
     */
    void update(Book book);

    /**
     *
     * @param id
     */
    void delete(Long id);

    /**
     * @return
     */
    List<Book> findAll();

    /**
     * @param id
     * @return
     */
    Book findById(Long id);

    /**
     * @param genre
     * @return
     */
    List<Book> findByGenre(Genre genre);

    /**
     *
     */
    void deleteAll();
}
