package org.booklibrary.business.dao;

import org.booklibrary.core.Book;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class BookDao implements GenericDaoInterface<Book> {
    private Session currentSession;
    private Transaction currentTransaction;

    public BookDao() {
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    @Override
    public void persist(Book entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Book entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Book findById(Long id) {
        Book book = (Book) getCurrentSession().get(Book.class, id);
        return book;
    }

    @Override
    public void delete(Book entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> findAll() {
        List<Book> books = (List<Book>) getCurrentSession().createQuery("from Book").list();
        return books;
    }

    @Override
    public void deleteAll() {
        List<Book> entityList = findAll();
        for (Book entity : entityList) {
            delete(entity);
        }
    }
}
