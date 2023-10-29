package com.example.demo.service;

import com.example.demo.entity.Book;

import java.util.List;

public interface BookService {
    public void addBook(Book book);

    public void updateBook(Book book);

    public void removeBook(int id);

    public Book getBooksById(int id);

    public List<Book> listBooks();

    public Book getBooks(String search);

    public void readBook(boolean isUpdate, Book book);
}
