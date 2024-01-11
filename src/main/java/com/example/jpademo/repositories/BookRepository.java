package com.example.jpademo.repositories;

import com.example.jpademo.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by Almaz on 11.01.2024
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
