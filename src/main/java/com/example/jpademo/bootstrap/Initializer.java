package com.example.jpademo.bootstrap;

import com.example.jpademo.domain.Book;
import com.example.jpademo.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * created by Almaz on 11.01.2024
 */
@Component
public class Initializer implements CommandLineRunner {
    private final BookRepository bookRepository;

    public Initializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Book bookDDO = Book.builder()
                .title("Java way")
                .publisher("Abdraeyev")
                .isbn("1245")
                .build();
        Book savedBook = bookRepository.save(bookDDO);
        System.out.println("savedBook id = " + savedBook.getId());

        Book bookDDO2 = Book.builder()
                .title("SQL")
                .publisher("Abdraeyev")
                .isbn("124567")
                .build();
        Book savedBook2 = bookRepository.save(bookDDO2);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Title " + book.getTitle() + ", id " + book.getId());
        });
    }
}
