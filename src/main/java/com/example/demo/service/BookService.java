package com.example.demo.service;

import com.example.demo.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public void addBook(Book book);

    public void updateBook(Book book);

    public void removeBook(long id);

    public Optional<Book> getBooksById(long id);

    public List<Book> listBooks();

    public Book getBooks(String search);

    public void readBook(boolean isRead, long id);

}
