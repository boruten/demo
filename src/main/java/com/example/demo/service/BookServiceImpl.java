package com.example.demo.service;

import com.example.demo.dao.BookDAO;
import com.example.demo.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookDAO bookDao;

    public void setBookDao(BookDAO bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        this.bookDao.addBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        this.bookDao.updateBook(book);
    }

    @Override
    @Transactional
    public void removeBook(int id) {
        this.bookDao.removeBook(id);
    }

    @Override
    @Transactional
    public Book getBooksById(int id) {
        return this.bookDao.getBooksById(id);
    }

    @Override
    @Transactional
    public List<Book> listBooks() {
        return this.bookDao.listBooks();
    }

    @Override
    @Transactional
    public Book getBooks(String search) {
        return this.bookDao.getBooks(search);
    }

    @Override
    @Transactional
    public void readBook(boolean isUpdate, Book book) {
        this.bookDao.readBook(isUpdate, book);
    }
}
