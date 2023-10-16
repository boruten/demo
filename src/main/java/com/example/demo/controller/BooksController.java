package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BooksController {


    private BookService bookService;
    private int currentPage = 0;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping(value = "/books")
    public String listBooks() {
        List<Book> books = this.bookService.listBooks();
        return books.toString();
    }

    @PostMapping(value = "/books/add")
    public String addBook(Book book) {
        if (book.getId() == 0) {
            this.bookService.addBook(book);
        } else {
            this.bookService.updateBook(book);
        }
        return String.valueOf(book);
    }

    @DeleteMapping(value = "{id}")
    public void removeBook(long id) {
        this.bookService.removeBook(id);
    }

    @PostMapping("edit/{id}")
    public String editBook(long id) {
        Optional<Book> book = this.bookService.getBooksById(id);
        this.bookService.readBook(true, id);
        List<Book> books = this.bookService.listBooks();
        return books.toString();
    }


    @PostMapping("bookData/{id}")
    public String bookData(long id) {
        Optional<Book> book = this.bookService.getBooksById(id);
        this.bookService.readBook(false, id);
        return String.valueOf(book);
    }

    @PostMapping(value = "books/search")
    public String searchBook(String searchTitle) {
        Book book = this.bookService.getBooks(searchTitle);
        return String.valueOf(book);
    }
}
