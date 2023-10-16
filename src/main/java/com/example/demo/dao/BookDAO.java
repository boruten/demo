package com.example.demo.dao;

import com.example.demo.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookDAO extends CrudRepository<Book, Long> {

}

