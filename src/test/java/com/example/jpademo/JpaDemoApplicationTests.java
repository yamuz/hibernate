package com.example.jpademo;

import com.example.jpademo.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class JpaDemoApplicationTests {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testBookRepo() {
        long count = bookRepository.count();
        System.out.println("**SpringBootTest** " + count);

        //bookRepository.findAll().forEach(book -> System.out.println(book.getTitle()));

        assertThat(count).isGreaterThan(0);
    }

    @Test
    void contextLoads() {
    }

}
