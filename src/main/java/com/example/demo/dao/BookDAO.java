package com.example.demo.dao;

import com.example.demo.entity.Book;

import java.util.List;

public interface BookDAO {
    public void addBook(Book book);
    public void updateBook(Book book);
    public void removeBook(int id);
    public Book getBooksById(int id);
    public List<Book> listBooks();
    Book getBooks(String search);
    public void readBook(boolean isUpdate, Book book);
}

