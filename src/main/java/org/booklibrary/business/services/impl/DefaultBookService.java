package org.booklibrary.business.services.impl;

import org.booklibrary.business.services.BookService;
import org.booklibrary.core.Book;
import org.booklibrary.core.Genre;
import org.booklibrary.business.dao.BookDao;

import java.util.List;

public class DefaultBookService implements BookService {

    private static BookDao bookDao;

    public DefaultBookService() {
        bookDao = new BookDao();
    }

    @Override
    public void persist(Book entity) {
        bookDao.openCurrentSessionwithTransaction();
        bookDao.persist(entity);
        bookDao.closeCurrentSessionwithTransaction();
    }

    @Override
    public void update(Book entity) {
        bookDao.openCurrentSessionwithTransaction();
        bookDao.update(entity);
        bookDao.closeCurrentSessionwithTransaction();
    }

    @Override
    public Book findById(Long id) {
        bookDao.openCurrentSession();
        Book book = bookDao.findById(id);
        bookDao.closeCurrentSession();
        return book;
    }

    @Override
    public void delete(Long id) {
        bookDao.openCurrentSessionwithTransaction();
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        bookDao.closeCurrentSessionwithTransaction();
    }

    @Override
    public List<Book> findAll() {
        bookDao.openCurrentSession();
        List<Book> books = bookDao.findAll();
        bookDao.closeCurrentSession();
        return books;
    }

    @Override
    public void deleteAll() {
        bookDao.openCurrentSessionwithTransaction();
        bookDao.deleteAll();
        bookDao.closeCurrentSessionwithTransaction();
    }

    @Override
    public List<Book> findByGenre(Genre genre) {
        return null;
    }

    public BookDao bookDao() {
        return bookDao;
    }
}
