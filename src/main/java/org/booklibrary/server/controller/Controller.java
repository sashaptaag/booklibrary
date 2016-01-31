package org.booklibrary.server.controller;

import java.util.List;
import org.booklibrary.server.Genre;
import org.booklibrary.server.Book;

public interface Controller {
    /**
     *
     * @param book
     */
    void addBook(Book book);

    /**
     *
     * @param title
     * @return
     */
    Book getByTitle(String title);

    /**
     *
     * @param isdn
     * @return
     */
    Book getByIsdn(String isdn);

    /**

     * @param genre
     * @return
     */
    List<Book> searchByGenre(Genre genre);
}
