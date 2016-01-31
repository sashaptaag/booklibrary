package org.booklibrary.server.controller;

import org.booklibrary.server.Book;
import org.booklibrary.server.Genre;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class LibraryController implements Controller {
    private static final String template = "The book is, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     *
     * @param book
     */
    @Override
    public void addBook(Book book) {
    }

    /**
     *
     * @param title
     * @return
     */
    @Override
    public Book getByTitle(String title) {
        return null;
    }

    @Override
    public Book getByIsdn(String isdn) {
        return null;
    }

    /**
     *
     * @param genre
     * @return
     */
    @Override
    public List<Book> searchByGenre(Genre genre) {
        return null;
    }

    /**
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public Book showbook(@RequestParam(value = "name", defaultValue = "GREAT BOOK") String name) {
        return new Book(counter.incrementAndGet(),
                String.format(template, name));
    }
}
