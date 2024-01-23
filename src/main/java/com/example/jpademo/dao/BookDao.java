package com.example.jpademo.dao;

import com.example.jpademo.domain.Book;

import java.util.List;

/**
 * created by Almaz on 23.01.2024
 */
public interface BookDao {
    List<Book> getBooks();
    Book save(Book book);
    Book findByTitleLike(String title);
}
