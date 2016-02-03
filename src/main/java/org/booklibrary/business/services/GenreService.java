package org.booklibrary.business.services;

import java.util.List;
import org.booklibrary.core.Genre;

public interface GenreService {
    /**
     *
     * @param genre
     * @return
     */
    Genre save(Genre genre);

    /**
     *
     * @param genre
     */
    void delete(Genre genre);

    /**
     *
     * @return
     */
    List<Genre> findAll();

    /**
     *
     * @param id
     * @return
     */
    Genre findById(Long id);
}
