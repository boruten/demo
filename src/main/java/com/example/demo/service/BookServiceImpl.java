package com.example.demo.service;

import com.example.demo.dao.BookDAO;
import com.example.demo.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private BookDAO bookDao;

    public void BookDao(BookDAO bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        bookDao.save(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        Optional<Book> optionalBook = bookDao.findById(book.getId());
        if (optionalBook.isEmpty()) {
            throw new IllegalArgumentException("Book not found");
        } else {
            bookDao.save(book);
        }


    }

    @Override
    @Transactional
    public void removeBook(long id) {
        Optional<Book> optionalBook = bookDao.findById(id);
        if (optionalBook.isEmpty()) {
            throw new IllegalArgumentException("Book not found");
        } else {
            bookDao.deleteById(id);
        }
    }

    @Override
    @Transactional
    public Optional<Book> getBooksById(long id) {
        return bookDao.findById(id);
    }

    @Override
    @Transactional
    public List<Book> listBooks() {
        return (List<Book>) bookDao.findAll();
    }


    @Transactional
    public Book getBooks(String search) {
        return null;
    }


    @Override
    @Transactional
    public void readBook(boolean isRead, long id) {
        /*Optional<Book> optionalBook = bookDao.findById(id);
        if (optionalBook.isEmpty()) {
            throw new IllegalArgumentException("Book not found");
        } else {
            bookDao.findById(readAlready,id);
            bookDao.save();

        }*/

    }
}
