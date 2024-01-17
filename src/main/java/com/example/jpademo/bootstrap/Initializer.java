package com.example.jpademo.bootstrap;

import com.example.jpademo.domain.Book;
import com.example.jpademo.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * created by Almaz on 11.01.2024
 */
@Component
@Profile({"local", "default"})
public class Initializer implements CommandLineRunner {
    private final BookRepository bookRepository;

    public Initializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();

        Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse");
        Book savedDDD = bookRepository.save(bookDDD);

        Book bookSIA = new Book("Spring In Action", "234234", "Oriely");
        Book savedSIA = bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id: " + book.getId());
            System.out.println("Book Title: " + book.getTitle());
        });

    }
}
