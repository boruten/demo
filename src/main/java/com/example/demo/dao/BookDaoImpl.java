package com.service;


import com.example.demo.dao.BookDAO;
import com.example.demo.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDAO {


    private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(book);
        logger.info("Book successfully saved. Book details: " + book);
    }

    @Override
    public void updateBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
        logger.info("Book successfully updated. Book details: " + book);
    }

    @Override
    public void removeBook(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));

        if (book != null) {
            session.delete(book);
        }

        logger.info("Book deleted successfully. Book details: " + book);
    }

    @Override
    public void readBook(boolean isUpdate, Book book) {
        Session session = this.sessionFactory.getCurrentSession();

        if (isUpdate)
            book.setReadAlready(false);
        else
            book.setReadAlready(true);
        session.update(book);

        logger.info("Book is read update. Book details: " + book);
    }

    @Override
    public Book getBooksById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));
        logger.info("Book successfully loaded. Book details: " + book);

        return book;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> listBooks() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Book> booksList = session.createQuery("from Book").list();


        for (Book b : booksList) {
            logger.info("Books list: " + b);
        }

        return booksList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Book getBooks(String search) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Book> booksList = session.createQuery("from Book where title =:title")
                .setParameter("title", search)
                .list();

        for (Book book : booksList) {
            logger.info("Book list: " + book);
        }

        return booksList.get(0);
    }
}
